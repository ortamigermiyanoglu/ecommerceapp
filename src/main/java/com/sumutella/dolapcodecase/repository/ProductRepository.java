package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Category;
import com.sumutella.dolapcodecase.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
