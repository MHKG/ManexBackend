package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_products")
public class TbProducts implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CLIENT_SUPPLIER_ID", nullable = false)
    private Integer clientSupplierId;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "LENGTH")
    private Float length;

    @Column(name = "WIDTH")
    private Float width;

    @Column(name = "HEIGHT")
    private Float height;

    @Column(name = "SIZE_UNIT")
    private Integer sizeUnit;

    @Column(name = "WEIGHT")
    private Float weight;

    @Column(name = "weight_unit")
    private String weightUnit;

    @Column(name = "VOLUME")
    private Float volume;

    @Column(name = "volume_unit")
    private String volumeUnit;
}
