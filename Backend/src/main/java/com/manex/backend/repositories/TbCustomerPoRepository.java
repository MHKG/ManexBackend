package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustomerPo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbCustomerPoRepository
        extends JpaRepository<TbCustomerPo, Integer>, JpaSpecificationExecutor<TbCustomerPo> {

    @Query("SELECT tcp FROM TbCustomerPo tcp WHERE tcp.CLIENT_CUST_ID = :clientCustId")
    TbCustomerPo findByClientCustId(int clientCustId);
}
