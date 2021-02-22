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
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
@ToString
public class Shoe extends Product {

    private Integer size;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_type_id")
    private DomainValue type;


}
