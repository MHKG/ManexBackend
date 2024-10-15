package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_product_spec")
public class TbProductSpec {

    @Id @Column private Integer PRODUCT_ID;

    @Column private String COLOUR;

    @Column private String MATERIAL;

    @Column private String PACKING;

    @Column private Float PRICE;
}
