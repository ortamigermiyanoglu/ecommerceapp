package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Brand;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import com.sumutella.dolapcodecase.repository.BrandRepository;
import com.sumutella.dolapcodecase.service.BrandQueryService;
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
public class BrandQueryServiceImpl implements BrandQueryService {
    private final BrandRepository brandRepository;
    private final ModelMapper mapper;


    @Override
    public List<IdCodeDisplayValueDTO> getBrands(String brandTypeCode) throws NotFoundException {
        List<Brand> brandList = brandRepository.findAllByBrandTypeCode(brandTypeCode);
        if (CollectionUtils.isEmpty(brandList)) {
            throw new NotFoundException("No Brand found with brand type code " + brandTypeCode);
        }
        return brandList.stream().map(brand -> mapper.map(brand, IdCodeDisplayValueDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Brand getBrand(Long brandId) throws NotFoundException {
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        return optionalBrand.orElseThrow(() -> new NotFoundException("No Brand Found with brand id " + brandId));
    }

}
