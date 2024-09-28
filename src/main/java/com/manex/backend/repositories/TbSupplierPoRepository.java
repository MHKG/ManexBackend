package com.manex.backend.repositories;

import com.manex.backend.entities.TbSupplierPo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbSupplierPoRepository
        extends JpaRepository<TbSupplierPo, Integer>, JpaSpecificationExecutor<TbSupplierPo> {

    @Query(
            "SELECT tsp FROM TbSupplierPo tsp WHERE tsp.CLIENT_SUPPLIER_ID = :clientSupplierId AND tsp.APP_CLIENT_ID = :appClientId")
    List<TbSupplierPo> findByAppClientIdAndClientSupplierId(int appClientId, int clientSupplierId);

    @Query("SELECT tsp FROM TbSupplierPo tsp WHERE tsp.CLIENT_SUPPLIER_ID = :CLIENT_SUPPLIER_ID")
    List<TbSupplierPo> findAllByClientSupplierId(String CLIENT_SUPPLIER_ID);

    @Query("SELECT tsp FROM TbSupplierPo tsp WHERE tsp.APP_CLIENT_ID = :APP_CLIENT_ID")
    List<TbSupplierPo> findAllByAppClientId(int APP_CLIENT_ID);
}
