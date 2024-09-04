package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_product_mm")
public class TbProductMm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "MM_FILE", nullable = false)
    private Integer mmFile;

    @Column(name = "default_mm")
    private String defaultMm;

    @Column(name = "STATUS")
    private Boolean status;
}
