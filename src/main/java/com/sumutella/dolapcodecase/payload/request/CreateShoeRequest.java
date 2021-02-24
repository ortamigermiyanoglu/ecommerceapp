package com.sumutella.dolapcodecase.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
public class CreateShoeRequest extends CreateProductRequest {
    @NotNull
    @Positive
    private Long shoeTypeId;
    @NotNull
    @Positive
    private Integer size;
}
