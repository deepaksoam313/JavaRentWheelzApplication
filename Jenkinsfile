pipeline {
    agent any
    tools{
        jdk 'jdk21'
        maven 'maven3'
    }
    
    environment {
        SCANNER_HOME= tool 'sonar-scanner'
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', credentialsId: 'git-cred', url: 'https://github.com/deepaksoam313/JavaRentWheelzApplication.git'
            }
        }
        
        stage('Compilation') {
            steps {
                sh "mvn compile"
            }
        }
        
        stage('Test') {
            steps {
                sh "mvn clean test"
            }
        }
        
        stage('Dependency Scan by Trivy') {
            steps {
                sh "trivy fs --format table -o trivy-dependencies-report.html ." 
            }
        }
        
        stage('Sonar Qube Analysis') {
            steps{
                withSonarQubeEnv('sonar') {
                    sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=BoardGame -Dsonar.projectKey=BoardGame \
                            -Dsonar.java.binaries=. '''
                }
            }
        }
        
        stage('Quality Gate Check') {
            steps{
                script {
                  waitForQualityGate abortPipeline: false, credentialsId: 'sonar-token' 
                }
            }
        }
        
        stage('Build Stage') {
            steps {
                sh "mvn clean package -X"
            }
        }
        
        stage('Publish Artifact to Nexus') {
            steps {
                withMaven(globalMavenSettingsConfig: 'global-settings', jdk: 'jdk21', maven: 'maven3', traceability: true) {
                    sh "mvn deploy"
                }
            }
        }
        
        stage('Verify Docker Version') {
            steps {
                sh 'docker --version'  // This will display the Docker version Jenkins is using
            }
        }
        
        stage('Build & Tag Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'docker-cred') {
                        sh "docker build -t deepaksom/board-shack:latest ."
                    }
                }
            }
        }
        
        stage('Docker Image Scan by Trivy') {
            steps {
                sh "trivy image --format table -o trivy-image-report.html deepaksom/board-shack:latest " 
            }
        }
        
        stage('Push Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'docker-cred') {
                        sh "docker push deepaksom/board-shack:latest"
                    }
                }
            }
        }
        
        stage('Deploy to K8s') {
            steps {
                withKubeConfig(caCertificate: '', clusterName: 'kubernetes', contextName: '', credentialsId: 'k8-cred', namespace: 'webapps', restrictKubeConfigAccess: false, serverUrl: 'https://172.31.39.195:6443') {
                    sh "kubectl apply -f deployment-service.yaml"
                    
                }
            }
        }
        
        stage('Verify the K8s Deployment') {
            steps {
                withKubeConfig(caCertificate: '', clusterName: 'kubernetes', contextName: '', credentialsId: 'k8-cred', namespace: 'webapps', restrictKubeConfigAccess: false, serverUrl: 'https://172.31.39.195:6443') {
                    sh "kubectl get pods -n webapps"
                    sh " kubectl get svc -n webapps"
                    
                }
            }
        }
        
        stage('Hello') {
            steps {
                echo "Hello"
            }
        }
    
    }
}
