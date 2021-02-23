package com.sumutella.dolapcodecase.payload.request;

import javax.validation.constraints.NotNull;

public class CreateDressRequest extends CreateProductRequest {
    @NotNull
    private Long dressTypeId;
    @NotNull
    private Long sizeId;

}
