package com.sumutella.dolapcodecase.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Product extends BaseEntity {
    private String description;
    @DecimalMin(value = "1.00", message = "price must be higher than {value}")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;
    @Range(min = 0, max = 100, message = "discount percentage must be between {min} and {max}")
    private Integer discountPercantege = 0;
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