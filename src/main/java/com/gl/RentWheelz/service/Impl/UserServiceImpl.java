package com.gl.RentWheelz.service.Impl;

import com.gl.RentWheelz.entity.User;
import com.gl.RentWheelz.exception.RentWheelzException;
import com.gl.RentWheelz.payload.User.LoginUserResponseDto;
import com.gl.RentWheelz.payload.User.RegisterUserResponseDto;
import com.gl.RentWheelz.payload.User.UserDetailPasswordDto;
import com.gl.RentWheelz.payload.User.UserDto;
import com.gl.RentWheelz.service.UserService;
import com.gl.RentWheelz.repository.UserRepository;
import com.gl.RentWheelz.utility.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    // map to dto
    private UserDto mapToDto(User user){
        return modelMapper.map(user,UserDto.class);
    }

    // map to entity
    private User mapToEntity(UserDto userDto){
        return modelMapper.map(userDto,User.class);
    }

    @Override
    public RegisterUserResponseDto registerUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();

        if(userRepository.findById(user.getUserName()).isPresent()){
            throw new RuntimeException(ConstantValues.USER_ALREADY_REGISTERED);
        }
        else{
            userRepository.save(user);
            registerUserResponseDto.setStatus(ConstantValues.SUCCESS);
            registerUserResponseDto.setMessage(ConstantValues.USER_REGISTERED_SUCCESSFULLY);
            return registerUserResponseDto;
        }


    }

    @Override
    public LoginUserResponseDto loginUser(String userName, String userPassword) throws RentWheelzException {
        User user = userRepository.findById(userName).orElse(null);

        LoginUserResponseDto loginUserResponseDto = new LoginUserResponseDto();

        if(user != null){
            loginUserResponseDto.setStatus(ConstantValues.SUCCESS);
            loginUserResponseDto.setMessage(ConstantValues.LOGIN_SUCCESSFULLY);
            loginUserResponseDto.setData(new UserDetailPasswordDto(user.getUserName(), user.getUserEmail(), user.getProofId()) );
            return loginUserResponseDto;
        }else{
            throw new RentWheelzException(ConstantValues.INVALID_CREDENTIALS);
        }
    }

}
