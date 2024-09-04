package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_company_addr")
public class TbCompanyAddr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "ADDR_ID", nullable = false)
    private Integer addrId;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "default_addr")
    private String defaultAddr;
}
