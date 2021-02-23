package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT DISTINCT c FROM Category c INNER JOIN c.categoryTypes ct where ct.code = :categoryTypeCode")
    List<Category> findAllByCategoryTypeCode(@Param("categoryTypeCode") String categoryTypeCode);
}
