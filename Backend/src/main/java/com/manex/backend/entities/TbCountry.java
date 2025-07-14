package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_country")
public class TbCountry {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "COUNTRY", nullable = false)
    private String COUNTRY;

    @Column(name = "ISO3", length = 3, columnDefinition = "CHAR(3)")
    private String ISO3;

    @Column(name = "ISO2", length = 2, columnDefinition = "CHAR(2)")
    private String ISO2;

    @Column(name = "COUNTRY_CODE")
    private String COUNTRY_CODE;

    @Column(name = "CAPITAL")
    private String CAPITAL;

    @Column(name = "NATIVE")
    private String NATIVE;
}
