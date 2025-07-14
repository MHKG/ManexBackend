package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustPoItems;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbCustPoItemsRepository
        extends JpaRepository<TbCustPoItems, Integer>, JpaSpecificationExecutor<TbCustPoItems> {

    @Query("SELECT tcpi FROM TbCustPoItems tcpi WHERE tcpi.CUST_PO_ID = :custPoId")
    TbCustPoItems findByCustPoId(Integer custPoId);
}
