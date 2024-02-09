package com.sulek.farmorigins.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {

    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "S_PRODUCT", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "category_id", length = 100)
    private Long category_id;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "unit_type_id") //ToDo unit type parametrik yap
    private Long unitTypeId;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;


}
