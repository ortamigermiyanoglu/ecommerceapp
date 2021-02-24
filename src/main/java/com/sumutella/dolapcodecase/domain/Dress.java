package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
@ToString
public class Dress {
    @Id
    private Long id;
    @NotNull
    private Boolean deleted = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_type_id")
    private DomainValue dressType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dress_size_id")
    private DomainValue size;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;


}
