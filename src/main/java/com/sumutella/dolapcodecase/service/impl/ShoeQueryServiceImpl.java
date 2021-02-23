package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.Shoe;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.ShoeDTO;
import com.sumutella.dolapcodecase.repository.ShoeRepository;
import com.sumutella.dolapcodecase.service.ShoeQueryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShoeQueryServiceImpl implements ShoeQueryService {
    private final ShoeRepository shoeRepository;
    private final ModelMapper mapper;


    @Override
    public ShoeDTO getShoe(Long shoeId) throws NotFoundException {
        Optional<Shoe> optionalShoe = shoeRepository.findById(shoeId);
        if (optionalShoe.isPresent()) {
            return mapper.map(optionalShoe.get(), ShoeDTO.class);
        }
        throw new NotFoundException("No shoe found with shoe id: " + shoeId);
    }
}
