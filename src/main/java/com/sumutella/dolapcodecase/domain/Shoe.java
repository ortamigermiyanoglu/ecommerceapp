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
@ToString
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
public class Shoe {
    @Id
    private Long id;
    private Integer size;
    @NotNull
    private Boolean deleted = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_type_id")
    private DomainValue shoeType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;


}
