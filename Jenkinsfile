pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                // Example: compile or build step
                // sh 'javac Main.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                // Exam


// pipeline {
//     agent any

//     tools {
//         maven 'Maven 3.8.5'   // This must match the Maven name in Jenkins tool config
//         jdk 'JDK 21'          // Or whatever Java version you use
//     }

//     stages {
//         stage('Clone Repository') {
//             steps {
//                 echo 'Cloning the repository...'
//                 git branch: 'main', url: 'https://github.com/deepaksoam313/JavaRentWheelzApplication.git'
//             }
//         }

//         stage('Build') {
//             steps {
//                 echo 'Building the application...'
//                 sh 'mvn clean compile'
//             }
//         }

//         stage('Test') {
//             steps {
//                 echo 'Running tests...'
//                 sh 'mvn test'
//             }
//         }

//         stage('Deploy') {
//             steps {
//                 echo 'Deploying the application...'
//                 // Add real deployment steps here if you need to deploy
//             }
//         }
//     }

//     post {
//         always {
//             echo 'Publishing test results...'
//             junit 'target/surefire-reports/*.xml'
//         }
//     }
// }
