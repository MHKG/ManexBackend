package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_user_address")
public class TbUserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "ADDR_ID", nullable = false)
    private Integer addrId;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "default_addr")
    private String defaultAddr;
}
