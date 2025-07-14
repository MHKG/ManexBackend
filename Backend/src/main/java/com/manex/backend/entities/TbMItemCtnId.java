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
public class TbMItemCtnId implements Serializable {

    private Integer PRODUCT_ID;
    private Integer CTN_ID;
}
