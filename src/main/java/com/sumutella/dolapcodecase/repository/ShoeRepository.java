package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
}
