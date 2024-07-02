package com.gl.RentWheelz.payload.CarDto.response;

import com.gl.RentWheelz.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisplayCarResponseDto {
    private String status;
    private Integer result;
    private List<Car> carList;
}
