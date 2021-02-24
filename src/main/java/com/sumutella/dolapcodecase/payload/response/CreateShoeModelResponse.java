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
@ApiModel("required data model to create a shoe product")
public class CreateShoeModelResponse extends CreateProductModelResponse {
    @ApiModelProperty("shoe types like running, boat, casual etc")
    List<IdCodeDisplayValueDTO> shoeTypes = new ArrayList<>();
}
