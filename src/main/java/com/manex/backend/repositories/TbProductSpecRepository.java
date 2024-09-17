package com.manex.backend.repositories;

import com.manex.backend.entities.TbProductSpec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbProductSpecRepository
        extends JpaRepository<TbProductSpec, Void>, JpaSpecificationExecutor<TbProductSpec> {

    @Query("SELECT tps FROM TbProductSpec tps WHERE tps.PRODUCT_ID = :productId")
    TbProductSpec findByProductId(int productId);
}
