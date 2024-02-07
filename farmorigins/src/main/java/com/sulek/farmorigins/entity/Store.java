package com.sulek.farmorigins.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Store extends BaseEntity {

    @Id
    @SequenceGenerator(name = "store_seq", sequenceName = "S_STORE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "store_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long id;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "address", length = 100) //Todo Address tablosuna çevir
    private String address;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number", length = 100)
    private String phoneNumber;

    @Column(name = "vkn", length = 100)
    private String vkn;

    @Column(name = "email_activision")
    private Boolean emailActivision;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @OneToMany
    @JoinColumn(name = "store_id")
    private List<Product> products;

}
