package com.sumutella.dolapcodecase.payload.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {
    @NotNull
    private Long usageStatusId;
    @NotNull
    private Long brandId;
    @NotNull
    private Long categoryTypeId;
    @NotNull
    private Long categoryId;
    @NotNull
    @Range(min = 0, max = 100, message = "discount percentage must be between {min} and {max}")
    private Integer discountPercentage;
    @DecimalMin("1.00")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
    private String description;

}
