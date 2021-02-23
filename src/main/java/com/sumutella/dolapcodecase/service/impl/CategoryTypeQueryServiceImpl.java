package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.CategoryType;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import com.sumutella.dolapcodecase.repository.CategoryTypeRepository;
import com.sumutella.dolapcodecase.service.CategoryTypeQueryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryTypeQueryServiceImpl implements CategoryTypeQueryService {
    private final CategoryTypeRepository categoryTypeRepository;
    private final ModelMapper mapper;

    @Override
    public List<IdCodeDisplayValueDTO> getCategoryTypes() {
        List<CategoryType> categoryTypeList = categoryTypeRepository.findAll();
        if (CollectionUtils.isEmpty(categoryTypeList)) {
            throw new EntityExistsException("Category types doesn't exist");
        }
        return categoryTypeList.stream().map(categoryType -> mapper.map(categoryType, IdCodeDisplayValueDTO.class)).collect(Collectors.toList());
    }
}
