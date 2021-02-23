package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Dress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends ProductRepository {
    List<Dress> findAllByDressTypeCode(String typeCode);

    List<Dress> findAllByDressTypeIdAndSizeId(Long typeId, Long sizeId);
}
