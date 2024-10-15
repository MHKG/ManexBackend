package com.manex.backend.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_customer_pi")
public class TbCustomerPi {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(nullable = false)
    private Integer CUST_QUOT_ID;

    @Column private String CUST_PI_NUM;

    @Column private Integer UPDATED_BY;

    @Column private Integer PI_MM;

    @Column private Date CREATED_ON;

    @Column private Integer STATUS;

    @Column private String REMARK;
}
