package com.manex.backend.repositories;

import com.manex.backend.entities.TbMItemCtn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TbMItemCtnRepository
        extends JpaRepository<TbMItemCtn, Integer>, JpaSpecificationExecutor<TbMItemCtn> {

    @Query("SELECT tmic FROM TbMItemCtn tmic WHERE tmic.id.PRODUCT_ID = :productId")
    TbMItemCtn findByProductId(int productId);
}
