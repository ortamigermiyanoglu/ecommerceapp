package com.sumutella.dolapcodecase.payload.response;

import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CreateDressModelResponse extends CreateProductModelResponse {
    List<IdCodeDisplayValueDTO> dressTypes = new ArrayList<>();
    List<IdCodeDisplayValueDTO> sizes = new ArrayList<>();
}
