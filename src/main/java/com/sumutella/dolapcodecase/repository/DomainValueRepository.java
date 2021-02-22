package com.sumutella.dolapcodecase.repository;

import com.sumutella.dolapcodecase.domain.DomainValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomainValueRepository extends JpaRepository<DomainValue, Long> {
    List<DomainValue> findAllByDomainValueTypeCode(String domainValueTypeCode);

}
