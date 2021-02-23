package com.sumutella.dolapcodecase.service;

import com.sumutella.dolapcodecase.domain.DomainValue;
import com.sumutella.dolapcodecase.exception.NotFoundException;
import com.sumutella.dolapcodecase.payload.dto.IdCodeDisplayValueDTO;

import java.util.List;

public interface DomainValueQueryService {
    List<IdCodeDisplayValueDTO> getDomainValues(String domainValueTypeCode) throws NotFoundException;

    DomainValue getDomainValue(Long domainValueId) throws NotFoundException;
}
