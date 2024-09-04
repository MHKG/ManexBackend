package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_client_cust")
public class TbClientCust implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "cust_num", nullable = false)
    private String custNum;

    @Column(name = "is_cust_fav")
    private Boolean custFav;

    @Column(name = "STATUS")
    private Integer status;
}
