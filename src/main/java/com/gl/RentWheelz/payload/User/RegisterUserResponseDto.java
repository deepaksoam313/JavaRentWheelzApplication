package com.gl.RentWheelz.payload.User;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponseDto {
    private String status;
    private String message;
}
