package com.manex.backend.entities;

public class ClientCustProjection {

    private TbClientCust tbClientCust;
    private TbCompany tbCompany;

    public ClientCustProjection(TbClientCust tbClientCust, TbCompany tbCompany) {
        this.tbClientCust = tbClientCust;
        this.tbCompany = tbCompany;
    }

    public TbClientCust getTbClientCust() {
        return tbClientCust;
    }

    public void setTbClientCust(TbClientCust tbClientCust) {
        this.tbClientCust = tbClientCust;
    }

    public TbCompany getTbCompany() {
        return tbCompany;
    }

    public void setTbCompany(TbCompany tbCompany) {
        this.tbCompany = tbCompany;
    }
}
