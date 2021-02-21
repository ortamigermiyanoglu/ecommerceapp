package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.payload.request.SignUpRequest;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;

public interface UserCommandService {
    MessageResponse createUser(SignUpRequest signupRequest);
}
