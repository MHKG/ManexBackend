package com.manex.backend.repositories;

import com.manex.backend.entities.TbProducts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbProductsRepository
        extends JpaRepository<TbProducts, Integer>, JpaSpecificationExecutor<TbProducts> {

    @Query("SELECT tp FROM TbProducts tp WHERE CLIENT_SUPPLIER_ID = :clientSupplierId")
    List<TbProducts> findCountByClientSupplierId(String clientSupplierId);
}
