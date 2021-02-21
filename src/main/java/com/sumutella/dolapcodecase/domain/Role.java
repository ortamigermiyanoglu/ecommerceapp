package com.sumutella.dolapcodecase.domain;

import com.sumutella.dolapcodecase.domain.domainutil.ERole;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
@Setter
@Getter
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}
