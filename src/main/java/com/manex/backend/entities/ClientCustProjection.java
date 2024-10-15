package com.manex.backend.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientCustProjection {

    private TbClientCust tbClientCust;
    private TbCompany tbCompany;

    public ClientCustProjection(TbClientCust tbClientCust, TbCompany tbCompany) {
        this.tbClientCust = tbClientCust;
        this.tbCompany = tbCompany;
    }
}
