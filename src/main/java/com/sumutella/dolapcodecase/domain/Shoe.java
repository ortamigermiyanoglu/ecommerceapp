package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
public class Shoe {
    @Id
    private Long id;
    private Integer size;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_type_id")
    private DomainValue shoeType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @MapsId
    private Product product;


}
