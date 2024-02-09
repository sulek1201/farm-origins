package com.sulek.farmorigins.entity.parameter;

import com.sulek.farmorigins.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "unit_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitType extends BaseEntity {

    @Id
    @SequenceGenerator(name = "unit_type_seq", sequenceName = "S_UNIT_TYPE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_type_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long id;

    @Column(name = "value", length = 200)
    private String value;

    @Column(name = "description", length = 100)
    private String description;

}
