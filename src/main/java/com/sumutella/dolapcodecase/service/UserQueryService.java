package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.payload.request.LoginRequest;
import com.sumutella.dolapcodecase.payload.response.JwtResponse;

public interface UserQueryService {
    JwtResponse signin(LoginRequest loginRequest);
}
