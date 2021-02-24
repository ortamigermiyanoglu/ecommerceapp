package com.sumutella.dolapcodecase.payload.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("model to create a dress product")
public class CreateDressRequest extends CreateProductRequest {
    @NotNull
    @Positive
    @ApiModelProperty("dress type id for types like jean, short, skirt etc")
    private Long dressTypeId;
    @NotNull
    @Positive
    @ApiModelProperty("dress size id for sizes like small, medium, large etc")
    private Long sizeId;

}
