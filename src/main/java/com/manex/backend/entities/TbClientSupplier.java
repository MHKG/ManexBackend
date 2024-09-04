package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_client_supplier")
public class TbClientSupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "APP_CLIENT_ID", nullable = false)
    private Integer appClientId;

    @Column(name = "supp_num", nullable = false)
    private String suppNum;

    @Column(name = "is_supp_fav")
    private Boolean suppFav;

    @Column(name = "STATUS")
    private Integer status;
}
