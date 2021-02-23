package com.sumutella.dolapcodecase.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class GetCategoriesRequest {
    private Long categoryTypeId;
    @NotNull
    private Long categoryId;
}
