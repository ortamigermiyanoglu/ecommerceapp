package com.sumutella.dolapcodecase.controller;

import com.sumutella.dolapcodecase.payload.request.LoginRequest;
import com.sumutella.dolapcodecase.payload.request.SignUpRequest;
import com.sumutella.dolapcodecase.service.UserCommandService;
import com.sumutella.dolapcodecase.service.UserQueryService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping("/signup")
    @ApiOperation(value = "", notes = "sign up to ecommerce app")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(userCommandService.createUser(signUpRequest));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "", notes = "sign in to ecommerce app")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userQueryService.signin(loginRequest));
    }
}
