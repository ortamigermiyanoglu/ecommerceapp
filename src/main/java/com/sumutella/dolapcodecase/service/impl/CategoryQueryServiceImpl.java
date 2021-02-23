package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Category;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import com.sumutella.dolapcodecase.repository.CategoryRepository;
import com.sumutella.dolapcodecase.service.CategoryQueryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryQueryServiceImpl implements CategoryQueryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    @Override
    public List<IdCodeDisplayValueDTO> getCategories(String categoryTypeCode) throws NotFoundException {
        List<Category> categoryList = categoryRepository.findAllByCategoryTypeCode(categoryTypeCode);
        if (CollectionUtils.isEmpty(categoryList)) {
            throw new NotFoundException("No category found with category type code " + categoryTypeCode);
        }
        return categoryList.stream().map(category -> mapper.map(category, IdCodeDisplayValueDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Category getCategory(Long categoryId) throws NotFoundException {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.orElseThrow(() -> new NotFoundException("No category found with category id " + categoryId));
    }
}
