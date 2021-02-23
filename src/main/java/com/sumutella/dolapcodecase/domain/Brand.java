package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
@Getter
@Setter
@ToString
public class Brand extends BaseEntity {
    private String code;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "brand_produces_relation",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "produces_id"))
    private Set<DomainValueType> brandTypes = new HashSet<>();


}
