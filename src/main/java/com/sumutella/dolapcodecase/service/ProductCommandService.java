package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.response.MessageResponse;

public interface ProductCommandService {
    MessageResponse deleteProduct(Long productId) throws NotFoundException;
}
