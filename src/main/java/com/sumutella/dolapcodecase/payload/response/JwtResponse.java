package com.sumutella.dolapcodecase.payload.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ApiModel("jwt response after authentication")
public class JwtResponse {
    @ApiModelProperty("jwt token")
    private String token;
    @ApiModelProperty("username")
    private String username;
    @ApiModelProperty("user roles")
    private List<String> roles;

}
