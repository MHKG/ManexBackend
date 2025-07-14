package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_user_address")
public class TbUserAddress {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer USER_ID;

    @Column(nullable = false)
    private Integer ADDR_ID;

    @Column private Boolean STATUS;

    @Column private Character DEFAULT_ADDR;
}
