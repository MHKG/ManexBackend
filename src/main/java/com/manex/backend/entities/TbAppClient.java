package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_app_client")
public class TbAppClient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "OPERATING_CURRENCY", nullable = false)
    private Integer operatingCurrency;

    @Column(name = "CLIENT_ICON")
    private Integer clientIcon;

    @Column(name = "client_color")
    private String clientColor;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "cust_num_format")
    private String custNumFormat;

    @Column(name = "supp_num_format")
    private String suppNumFormat;

    @Column(name = "cust_or_num_format")
    private String custOrNumFormat;

    @Column(name = "supp_or_num_format")
    private String suppOrNumFormat;
}
