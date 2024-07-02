package com.gl.RentWheelz.service;

import com.gl.RentWheelz.entity.Car;
import com.gl.RentWheelz.payload.CarDto.CarDto;
import com.gl.RentWheelz.payload.CarDto.response.DisplayCarResponseDto;
import com.gl.RentWheelz.payload.CarDto.response.RegisterCarResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarService {
    public RegisterCarResponseDto registerCar(CarDto carDto);
    public DisplayCarResponseDto DisplayAllCars();

}
