package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("SELECT DISTINCT b FROM Brand b INNER JOIN b.brandTypes bt where bt.code = :brandTypeCode")
    List<Brand> findAllByBrandTypeCode(@Param("brandTypeCode") String brandTypeCode);


}
