package com.sulek.farmorigins.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "S_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @Column(name = "id", columnDefinition = "numeric(19)")
    private Long id;

    @Column(name = "pwd", length = 200)
    private String password;

    @Column(name = "first_name", length = 200)
    private String firstName;

    @Column(name = "last_name", length = 200)
    private String lastName;

    @Column(name = "phone_number", length = 100, unique = true)
    private String phoneNumber;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "user_role", length = 100)
    private Integer userRole;

    @Column(name = "email_activision", length = 200)
    private Boolean emailActivision;
}
