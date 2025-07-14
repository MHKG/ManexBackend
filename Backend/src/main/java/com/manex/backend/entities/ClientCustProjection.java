package com.manex.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
@AllArgsConstructor
public class ClientCustProjection {

    private TbClientCust tbClientCust;
    private TbCompany tbCompany;
}
