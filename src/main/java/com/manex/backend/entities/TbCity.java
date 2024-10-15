package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_city")
public class TbCity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private String CITY;

    @Column(nullable = false)
    private Integer DISTRICT_ID;

    @Column private Double LATITUDE;

    @Column private Double LONGITUDE;
}
