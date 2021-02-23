package com.sumutella.dolapcodecase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class NotFoundException extends Exception {
    private String message;
}
