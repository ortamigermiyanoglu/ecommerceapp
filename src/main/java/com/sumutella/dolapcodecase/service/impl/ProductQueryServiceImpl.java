package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Category;
import com.sumutella.dolapcodecase.domain.Product;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.ProductDTO;
import com.sumutella.dolapcodecase.repository.ProductRepository;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import com.sumutella.dolapcodecase.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {
    private final ProductRepository productRepository;
    private final CategoryQueryService categoryQueryService;
    private final ModelMapper mapper;

    @Override
    public List<ProductDTO> getProducts(Long categoryTypeId, Long categoryId) throws NotFoundException {
        Category category = categoryQueryService.getCategory(categoryTypeId, categoryId);
        List<Product> productList = productRepository.findAllByCategory(category);
        if (CollectionUtils.isEmpty(productList)) {
            throw new NotFoundException("No product found with category type id: " + categoryTypeId + " and category id: " + categoryId);
        }
        return productList.stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProducts(Long categoryId) throws NotFoundException {
        Category category = categoryQueryService.getCategory(categoryId);
        List<Product> productList = productRepository.findAllByCategory(category);
        if (CollectionUtils.isEmpty(productList)) {
            throw new NotFoundException("No product found with category id: " + categoryId);
        }
        return productList.stream().map(product -> mapper.map(product, ProductDTO.class)).collect(Collectors.toList());
    }
}
