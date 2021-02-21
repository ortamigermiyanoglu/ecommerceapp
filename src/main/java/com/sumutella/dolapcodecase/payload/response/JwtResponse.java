package com.sumutella.dolapcodecase.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String username;
    private List<String> roles;


}
