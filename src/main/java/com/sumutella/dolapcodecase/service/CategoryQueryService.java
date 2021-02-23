package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.domain.Category;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;

import java.util.List;

public interface CategoryQueryService {
    List<IdCodeDisplayValueDTO> getCategories(String categoryTypeCode) throws NotFoundException;

    Category getCategory(Long categoryTypeId, Long categoryId) throws NotFoundException;
}
