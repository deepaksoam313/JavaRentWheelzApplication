package com.gl.RentWheelz.controller;

import com.gl.RentWheelz.payload.CarDto.CarDto;
import com.gl.RentWheelz.payload.CarDto.response.DisplayCarResponseDto;
import com.gl.RentWheelz.payload.CarDto.response.RegisterCarResponseDto;
import com.gl.RentWheelz.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //-------------------------------------------CAR------------------------------------------------------
    @PostMapping
    @RequestMapping("/registerCar")
    public ResponseEntity<RegisterCarResponseDto> registerCar (@Valid @RequestBody CarDto carDto){
        RegisterCarResponseDto responseMessage = carService.registerCar(carDto);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping("/getAllCars")
    public ResponseEntity<DisplayCarResponseDto> geAllCars (){

        DisplayCarResponseDto responseMessage = carService.DisplayAllCars();

        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
