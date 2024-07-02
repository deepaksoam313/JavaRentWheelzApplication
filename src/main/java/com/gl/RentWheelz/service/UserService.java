package com.gl.RentWheelz.service;


import com.gl.RentWheelz.exception.RentWheelzException;
import com.gl.RentWheelz.payload.User.LoginUserResponseDto;
import com.gl.RentWheelz.payload.User.RegisterUserResponseDto;
import com.gl.RentWheelz.payload.User.UserDto;

public interface UserService {
    public RegisterUserResponseDto registerUser(UserDto userDto) throws RentWheelzException;

    public LoginUserResponseDto loginUser(String userName, String userPassword) throws RentWheelzException;
}
