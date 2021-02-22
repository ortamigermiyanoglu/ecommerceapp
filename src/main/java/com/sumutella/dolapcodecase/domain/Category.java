package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Setter
@Getter
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
public class Category extends BaseEntity {
    private String code;
    private String name;
    private String description;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_type_id", nullable = false)
    private CategoryType categoryType;

}
