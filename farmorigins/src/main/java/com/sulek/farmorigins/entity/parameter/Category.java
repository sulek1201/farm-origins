package com.sulek.farmorigins.entity.parameter;

import com.sulek.farmorigins.entity.BaseEntity;
import com.sulek.farmorigins.entity.Product;
import com.sulek.farmorigins.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity {

    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "S_CATEGORY", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long value;

    @Column(name = "value", length = 200)
    private String label;

    @Column(name = "description", length = 100)
    private String description;

}
