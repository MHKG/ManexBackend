package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_all_addr")
public class TbAllAddr {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer APP_CLIENT_ID;

    @Column(nullable = false)
    private String ADDR_1;

    @Column private String ADDR_2;

    @Column(nullable = false)
    private Integer COUNTRY_ID;

    @Column private Integer STATE_ID;

    @Column private Integer DISTRICT_ID;

    @Column private Integer CITY_ID;

    @Column private String POSTAL_CODE;
}
