package com.sumutella.dolapcodecase.payload.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public abstract class ProductDTO {
    private Long id;
    private String productUsageStatusName;
    private String productCategoryName;
    private String productDescription;
    private BigDecimal productPrice;
    private Integer productDiscountPercentage;
}
