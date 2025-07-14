package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_product_mm")
public class TbProductMm {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer PRODUCT_ID;

    @Column(nullable = false)
    private Integer MM_FILE;

    @Column private Character DEFAULT_MM;

    @Column private Boolean STATUS;

    public Boolean isStatus() {
        return STATUS;
    }
}
