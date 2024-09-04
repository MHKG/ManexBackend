package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_company")
public class TbCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "tax_number")
    private String taxNumber;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "alt_contact_number")
    private String altContactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "fax")
    private String fax;

    @Column(name = "website")
    private String website;

    @Column(name = "LOGO")
    private Integer logo;

    @Column(name = "CREATED_DATE")
    private Integer createdDate;
}
