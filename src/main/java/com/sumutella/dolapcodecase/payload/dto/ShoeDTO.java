package com.sumutella.dolapcodecase.payload.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShoeDTO extends ProductDTO {
    private Integer size;
    private String shoeTypeName;
}
