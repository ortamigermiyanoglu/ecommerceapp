package com.sumutella.dolapcodecase.payload.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@ApiModel("user sign up model")
public class SignUpRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @ApiModelProperty(" user roles like moderator, admin, user etc")
    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

}
