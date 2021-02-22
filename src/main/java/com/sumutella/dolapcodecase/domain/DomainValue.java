package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@ToString
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
public class DomainValue extends BaseEntity {
    private String code;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "domain_value_type_id")
    private DomainValueType domainValueType;
}
