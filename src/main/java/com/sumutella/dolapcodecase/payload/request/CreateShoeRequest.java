package com.sumutella.dolapcodecase.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CreateShoeRequest extends CreateProductRequest {
    @NotNull
    private Long shoeTypeId;
    @NotNull
    private Integer size;
}
