package com.sumutella.dolapcodecase.service.impl;

import com.sumutella.dolapcodecase.domain.DomainValue;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;
import com.sumutella.dolapcodecase.repository.DomainValueRepository;
import com.sumutella.dolapcodecase.service.DomainValueQueryService;
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
public class DomainValueQueryServiceImpl implements DomainValueQueryService {
    private final DomainValueRepository domainValueRepository;
    private final ModelMapper mapper;

    @Override
    public List<IdCodeDisplayValueDTO> getDomainValues(String domainValueTypeCode) throws NotFoundException {
        List<DomainValue> domainValueList = domainValueRepository.findAllByDomainValueTypeCode(domainValueTypeCode);
        if (CollectionUtils.isEmpty(domainValueList)) {
            throw new NotFoundException("No domain value found with domain value type code: " + domainValueTypeCode);
        }

        return domainValueList.stream().map(domainValue -> mapper.map(domainValue, IdCodeDisplayValueDTO.class)).collect(Collectors.toList());
    }

    @Override
    public DomainValue getDomainValue(Long domainValueId) throws NotFoundException {
        Optional<DomainValue> optionalDomainValue = domainValueRepository.findById(domainValueId);
        return optionalDomainValue.orElseThrow(() -> new NotFoundException("No domain value found with domain value id: " + domainValueId));
    }
}
