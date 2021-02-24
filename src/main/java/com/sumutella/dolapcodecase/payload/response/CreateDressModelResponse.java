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
@ApiModel("required data model to create a dress product")
public class CreateDressModelResponse extends CreateProductModelResponse {
    @ApiModelProperty("dress types like jean,skirt,short etc")
    List<IdCodeDisplayValueDTO> dressTypes = new ArrayList<>();
    @ApiModelProperty("dress size like small,medium,large etc")
    List<IdCodeDisplayValueDTO> sizes = new ArrayList<>();
}
