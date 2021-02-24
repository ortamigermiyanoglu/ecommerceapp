package com.sumutella.dolapcodecase.payload.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@ApiModel("model to create a product")
public class CreateProductRequest {
    @NotNull
    @Positive
    @ApiModelProperty("product usage status id for statuses like New, Used, Less Used etc")
    private Long usageStatusId;
    @NotNull
    @Positive
    @ApiModelProperty("product brands id for brands like Adidas, Nike, LC Waikiki etc")
    private Long brandId;
    @NotNull
    @Positive
    @ApiModelProperty("product category type id for types like Man, Woman, Electronics etc")
    private Long categoryTypeId;
    @NotNull
    @Positive
    @ApiModelProperty("product category id for categories like shoe, clothing, phones etc")
    private Long categoryId;
    @NotNull
    @Range(min = 0, max = 100, message = "discount percentage must be between {min} and {max}")
    @ApiModelProperty("product discount percentage")
    private Integer discountPercentage;
    @DecimalMin("1.00")
    @Digits(integer = 6, fraction = 2)
    @ApiModelProperty("product price")
    private BigDecimal price;
    @NotBlank
    @ApiModelProperty("product description")
    private String description;

}
