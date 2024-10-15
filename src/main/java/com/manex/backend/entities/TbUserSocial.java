package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_user_social")
public class TbUserSocial {

    @Id
    @Column(nullable = false)
    private Integer SM_ID;

    @Column(nullable = false)
    private Integer USER_ID;

    @Column private String SM_HANDLE;

    @Column private Integer STATUS;

    @Column private String ADDL_INFO;
}
