package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_company")
public class TbCompany {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column private String NAME;

    @Column private String REG_NUMBER;

    @Column private String TAX_NUMBER;

    @Column private String CONTACT_NUMBER;

    @Column private String ALT_CONTACT_NUMBER;

    @Column private String EMAIL;

    @Column private String FAX;

    @Column private String WEBSITE;

    @Column private Integer LOGO;

    @Column private Date CREATED_DATE;
}
