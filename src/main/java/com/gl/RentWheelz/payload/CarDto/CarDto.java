package com.gl.RentWheelz.payload.CarDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    @NotEmpty
    private String carModel;

    @NotEmpty
    private String registrationNumber;

    @NotEmpty
    private String carAvailability;

    @NotEmpty
    private String brand;

    //@NotEmpty
    private double pricePerHour;
}
