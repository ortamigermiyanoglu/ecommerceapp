package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Dress;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends ProductRepository {
    List<Dress> findAllByTypeCode(String typeCode);

    List<Dress> findAllByTypeIdAndSizeId(Long typeId, Long sizeId);
}
