package com.gl.RentWheelz.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(unique = true, nullable = false)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userName;

    @Email
    @Column(unique = true, nullable = false)
    private String userEmail;

    @Column(unique = true, nullable = false)
    private String userPassword;

    @Column(unique = true, nullable = false)
    private String proofId;
}
