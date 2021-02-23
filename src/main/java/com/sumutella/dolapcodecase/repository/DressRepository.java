package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DressRepository extends JpaRepository<Dress, Long> {
    List<Dress> findAllByDressTypeCode(String typeCode);

    List<Dress> findAllByDressTypeIdAndSizeId(Long typeId, Long sizeId);
}
