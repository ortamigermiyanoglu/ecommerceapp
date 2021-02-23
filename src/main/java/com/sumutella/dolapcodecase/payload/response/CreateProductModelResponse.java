package com.sumutella.dolapcodecase.payload.response;

import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class CreateProductModelResponse {
    private List<IdCodeDisplayValueDTO> categoryTypes = new ArrayList<>();
    private List<IdCodeDisplayValueDTO> categories = new ArrayList<>();
    private List<IdCodeDisplayValueDTO> brands = new ArrayList<>();
    private List<IdCodeDisplayValueDTO> usageStatuses = new ArrayList<>();
}
