package com.sumutella.dolapcodecase.service;


import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.ProductDTO;

import java.util.List;

public interface ProductQueryService {
    List<ProductDTO> getProducts(Long categoryTypeId, Long categoryId) throws NotFoundException;

    List<ProductDTO> getProducts(Long categoryId) throws NotFoundException;

}
