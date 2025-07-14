package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class TbMClientSupplierItemId implements Serializable {

    private Integer CLIENT_SUPP_ID;
    private Integer PROD_ID;
}
