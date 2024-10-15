package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_users")
public class TbUsers {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String EMAIL;

    @Column private String PASSWORD;

    @Column private Integer USER_TYPE;

    @Column private String RESET_PASS;
}
