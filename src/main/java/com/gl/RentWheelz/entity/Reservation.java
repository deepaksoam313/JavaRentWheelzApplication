package com.gl.RentWheelz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String bookingId;

    @JoinColumn(name = "user_email", unique = true, nullable = false)
    private String userEmail;

    @JoinColumn(name = "carId", unique = true, nullable = false)
    private String carID;

    @Column(nullable = false)
    private Date reservationDate;

    @Column(nullable = false)
    private Date pickUpDate;

    @Column(nullable = false)
    private Date returnDate;
}
