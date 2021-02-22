package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
public class CategoryType extends BaseEntity {
    private String code;
    private String name;
    private String description;

}
