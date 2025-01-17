package com.gl.RentWheelz.payload.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserResponseDto {
    private String status;
    private String message;
    private UserDetailPasswordDto data;

}
