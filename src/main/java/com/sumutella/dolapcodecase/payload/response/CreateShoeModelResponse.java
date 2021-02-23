package com.sumutella.dolapcodecase.payload.response;

import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateShoeModelResponse extends CreateProductModelResponse {
    List<IdCodeDisplayValueDTO> shoeTypes = new ArrayList<>();
}
