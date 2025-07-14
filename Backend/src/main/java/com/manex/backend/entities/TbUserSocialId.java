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
public class TbUserSocialId implements Serializable {

    private Integer USER_ID;
    private Integer SM_ID;
}
