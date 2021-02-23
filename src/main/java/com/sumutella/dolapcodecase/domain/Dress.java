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
public class Dress extends Product {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_type_id")
    private DomainValue dressType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_size_id")
    private DomainValue size;


}
