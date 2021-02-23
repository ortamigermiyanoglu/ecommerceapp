package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.ShoeDTO;

public interface ShoeQueryService {
    ShoeDTO getShoe(Long shoeId) throws NotFoundException;
}
