package com.sumutella.dolapcodecase.payload.response;

import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ApiModel("Required data model to create product")
public abstract class CreateProductModelResponse {
    @ApiModelProperty("product category types like man, woman, electronics etc")
    private List<IdCodeDisplayValueDTO> categoryTypes = new ArrayList<>();
    @ApiModelProperty("product categories like shoes, clothing etc")
    private List<IdCodeDisplayValueDTO> categories = new ArrayList<>();
    @ApiModelProperty("product brands like lC Waikiki, H&M, Adidas etc")
    private List<IdCodeDisplayValueDTO> brands = new ArrayList<>();
    @ApiModelProperty("product usage statuses like new, less used, used etc")
    private List<IdCodeDisplayValueDTO> usageStatuses = new ArrayList<>();
}
