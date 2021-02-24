package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.Dress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DressRepository extends JpaRepository<Dress, Long> {
    //TODO
}
