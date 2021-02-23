package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Entity
@Where(clause = BaseEntity.SOFT_DELETE_CLAUSE)
public class Product extends BaseEntity {
    private String description;
    @DecimalMin(value = "1.00", message = "price must be higher than {value}")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
    @Range(min = 0, max = 100, message = "discount percentage must be between {min} and {max}")
    private Integer discountPercentage = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usage_status_id")
    private DomainValue usageStatus;

}