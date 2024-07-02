package com.gl.RentWheelz.payload.ReservationDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {

    @NotNull
    private Date reservationDate;

    @NotNull
    private Date pickUpDate;

    @NotNull
    private Date returnDate;
}
