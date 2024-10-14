package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbUserSocialId implements Serializable {

    private Integer USER_ID;
    private Integer SM_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUserSocialId that = (TbUserSocialId) o;
        return Objects.equals(USER_ID, that.USER_ID) && Objects.equals(SM_ID, that.SM_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(USER_ID, SM_ID);
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getSM_ID() {
        return SM_ID;
    }

    public void setSM_ID(Integer SM_ID) {
        this.SM_ID = SM_ID;
    }
}
