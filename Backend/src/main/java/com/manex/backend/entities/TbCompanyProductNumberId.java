package com.manex.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class TbCompanyProductNumberId implements Serializable {

    @Column(name = "PRODUCT_ID")
    private int PRODUCT_ID;

    @Column(name = "APP_CLIENT_ID")
    private int APP_CLIENT_ID;

    @Column(name = "COMPANY_ID")
    private int COMPANY_ID;
}
