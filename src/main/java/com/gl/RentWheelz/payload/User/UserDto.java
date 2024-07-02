package com.gl.RentWheelz.payload.User;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotEmpty
    private String userName;

    @NotEmpty
    @Email
    private String userEmail;

    @NotEmpty
    private String userPassword;

    @NotEmpty
    private String proofId;


}
