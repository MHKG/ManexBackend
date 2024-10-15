package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_company_product_number")
public class TbCompanyProductNumber {

    @EmbeddedId private TbCompanyProductNumberId ID;

    @Column(nullable = false)
    private String ITEM_NO;

    @Column private String BAR_CODE;

    @Column private String DUN_BAR_CODE;
}
