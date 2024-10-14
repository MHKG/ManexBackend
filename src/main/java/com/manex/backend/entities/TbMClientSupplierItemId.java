package com.manex.backend.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TbMClientSupplierItemId implements Serializable {

    private Integer CLIENT_SUPP_ID;
    private Integer PROD_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbMClientSupplierItemId that = (TbMClientSupplierItemId) o;
        return Objects.equals(CLIENT_SUPP_ID, that.CLIENT_SUPP_ID)
                && Objects.equals(PROD_ID, that.PROD_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CLIENT_SUPP_ID, PROD_ID);
    }

    public Integer getPROD_ID() {
        return PROD_ID;
    }

    public void setPROD_ID(Integer PROD_ID) {
        this.PROD_ID = PROD_ID;
    }

    public Integer getCLIENT_SUPP_ID() {
        return CLIENT_SUPP_ID;
    }

    public void setCLIENT_SUPP_ID(Integer CLIENT_SUPP_ID) {
        this.CLIENT_SUPP_ID = CLIENT_SUPP_ID;
    }
}
