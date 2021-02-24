package com.sumutella.dolapcodecase.payload.request;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ApiModel("login model to authenticate")
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
