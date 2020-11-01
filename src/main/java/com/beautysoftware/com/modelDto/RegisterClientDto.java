package com.beautysoftware.com.modelDto;

import com.beautysoftware.com.validation.ValidEmail;
import com.beautysoftware.com.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterClientDto {
    @NotNull(message = "Name cannot be null")
    @Size(min = 5, max = 50)
    private String nickName;
    @ValidEmail(message = "Valid Email is required")
    private String email;
    @NotBlank(message = "Password is required.")
    @ValidPassword

    private String password;
    @NotBlank(message = "Repeat your password")

    private String confirmPassword;

    public RegisterClientDto(String nickName, String email, String password, String confirmPassword) {
        this.nickName = nickName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
}
