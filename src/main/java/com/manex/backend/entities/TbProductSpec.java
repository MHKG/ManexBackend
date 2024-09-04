package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_product_spec")
public class TbProductSpec implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "colour")
    private String colour;

    @Column(name = "material")
    private String material;

    @Column(name = "packing")
    private String packing;

    @Column(name = "PRICE")
    private Float price;
}
