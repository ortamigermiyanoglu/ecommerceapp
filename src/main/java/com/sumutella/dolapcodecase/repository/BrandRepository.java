package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByBrandTypeCode(String typeCode);
}
