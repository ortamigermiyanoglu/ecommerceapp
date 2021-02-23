package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.domain.Brand;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;

import java.util.List;

public interface BrandQueryService {
    List<IdCodeDisplayValueDTO> getBrands(String brandTypeCode) throws NotFoundException;

    Brand getBrand(Long brandId) throws NotFoundException;
}
