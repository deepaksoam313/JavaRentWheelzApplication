package com.gl.RentWheelz.service.Impl;

import com.gl.RentWheelz.entity.Car;
import com.gl.RentWheelz.entity.User;
import com.gl.RentWheelz.payload.CarDto.CarDto;
import com.gl.RentWheelz.payload.CarDto.response.DisplayCarResponseDto;
import com.gl.RentWheelz.payload.CarDto.response.RegisterCarResponseDto;
import com.gl.RentWheelz.payload.User.UserDto;
import com.gl.RentWheelz.repository.CarRepository;
import com.gl.RentWheelz.service.CarService;
import com.gl.RentWheelz.utility.ConstantValues;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    // map to dto
    private CarDto mapToDto(Car car){
        return modelMapper.map(car,CarDto.class);
    }

    // map to entity
    private Car mapToEntity(CarDto carDto){
        return modelMapper.map(carDto, Car.class);
    }


    @Override
    public RegisterCarResponseDto registerCar(CarDto carDto) {
        Car car = mapToEntity(carDto);
        RegisterCarResponseDto registerCarResponseDto = new RegisterCarResponseDto();

//        if(carRepository.findById(car.getRegistrationNumber()).isPresent()){
//            registerCarResponseDto.setStatus(ConstantValues.FAILURE);
//            registerCarResponseDto.setMessage(ConstantValues.CAR_NOT_REGISTERED);
//            return registerCarResponseDto;
////            throw new RuntimeException("Car already registered");
//        }
//        else{
            carRepository.save(car);
            registerCarResponseDto.setStatus(ConstantValues.SUCCESS);
            registerCarResponseDto.setMessage(ConstantValues.CAR_REGISTERED_SUCCESSFULLY);
            return registerCarResponseDto;
        //}
    }

    @Override
    public DisplayCarResponseDto DisplayAllCars() {
        DisplayCarResponseDto displayCarResponseDto = new DisplayCarResponseDto();

        int result = (int) carRepository.count();
        List<Car> carList = carRepository.findAll().stream().filter(car -> car.getCarAvailability().equals("Available")).toList();
        displayCarResponseDto.setStatus(ConstantValues.SUCCESS);
        displayCarResponseDto.setResult(result);
        displayCarResponseDto.setCarList(carList);


        return displayCarResponseDto;
    }
}
