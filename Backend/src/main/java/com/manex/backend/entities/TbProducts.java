package com.manex.backend.entities;

import com.manex.backend.enums.SizeUnit;
import com.manex.backend.enums.VolumeUnit;
import com.manex.backend.enums.WeightUnit;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_products")
public class TbProducts {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CLIENT_SUPPLIER_ID;

    @Column(nullable = false)
    private String NAME;

    @Column(nullable = false)
    private String DESCRIPTION;

    @Column private Float LENGTH;

    @Column private Float WIDTH;

    @Column private Float HEIGHT;

    @Column
    @Enumerated(EnumType.STRING)
    private SizeUnit SIZE_UNIT;

    @Column private Float WEIGHT;

    @Column
    @Enumerated(EnumType.STRING)
    private WeightUnit WEIGHT_UNIT;

    @Column private Float VOLUME;

    @Column
    @Enumerated(EnumType.STRING)
    private VolumeUnit VOLUME_UNIT;
}
