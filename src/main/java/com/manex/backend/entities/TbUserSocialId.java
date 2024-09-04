package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbUserSocialId implements Serializable {

    private Integer userId;
    private Integer smId;

    // Default constructor
    public TbUserSocialId() {}

    // Parameterized constructor
    public TbUserSocialId(Integer productId, Integer companyId) {
        this.userId = productId;
        this.smId = companyId;
    }

    // Getters, setters, equals, and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbUserSocialId that = (TbUserSocialId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(smId, that.smId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, smId);
    }

    // Getters and setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSmId() {
        return smId;
    }

    public void setSmId(Integer smId) {
        this.smId = smId;
    }
}
