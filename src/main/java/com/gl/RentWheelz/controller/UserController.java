package com.gl.RentWheelz.controller;

import com.gl.RentWheelz.exception.RentWheelzException;
import com.gl.RentWheelz.payload.User.LoginUserResponseDto;
import com.gl.RentWheelz.payload.User.RegisterUserResponseDto;
import com.gl.RentWheelz.payload.User.UserDto;
import com.gl.RentWheelz.payload.User.UserLoginDto;
import com.gl.RentWheelz.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //-------------------------------------------USER------------------------------------------------------
    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> registerUser(@Valid @RequestBody UserDto userDto) throws RentWheelzException {
        RegisterUserResponseDto responseMessage = userService.registerUser(userDto);
        //UserResponse responseMessage = new UserResponse("User registered successfully",createdUser);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponseDto> loginUser(@Valid @RequestBody UserLoginDto userLoginDto) throws RentWheelzException {
        LoginUserResponseDto responseMessage = userService.loginUser(userLoginDto.getUsername(), userLoginDto.getPassword());
        //UserResponse responseMessage = new UserResponse("User registered successfully",createdUser);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }



}
