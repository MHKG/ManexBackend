package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_app_client")
public class TbAppClient {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer COMPANY_ID;

    @Column(nullable = false)
    private Integer OPERATING_CURRENCY;

    @Column private Integer CLIENT_ICON;

    @Column private String CLIENT_COLOR;

    @Column private Boolean STATUS;

    @Column private String CUST_NUM_FORMAT;

    @Column private String SUPP_NUM_FORMAT;

    @Column private String CUST_OR_NUM_FORMAT;

    @Column private String SUPP_OR_NUM_FORMAT;
}
