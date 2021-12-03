package com.example.springcard.payload;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginDto {
    @NotNull
    private String phoneNumber;
    @NotNull
    private String password;
}
