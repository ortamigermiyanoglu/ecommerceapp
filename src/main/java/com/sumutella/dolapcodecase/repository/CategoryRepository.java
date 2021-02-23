package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT DISTINCT c FROM Category c INNER JOIN c.categoryType ct where ct.code = :categoryTypeCode")
    List<Category> findAllByCategoryTypeCode(@Param("categoryTypeCode") String categoryTypeCode);

    @Query("SELECT DISTINCT c FROM Category c INNER JOIN c.categoryType ct WHERE ct.id = :categoryTypeId AND c.id =:categoryId")
    Category findCategoryByCriteria(@Param("categoryTypeId") Long categoryTypeId, @Param("categoryId") Long categoryId);
}
