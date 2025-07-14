package com.manex.backend.repositories;

import com.manex.backend.entities.TbProducts;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TbProductsRepository
        extends JpaRepository<TbProducts, Integer>, JpaSpecificationExecutor<TbProducts> {

    @Query(
            "SELECT tp FROM TbProducts tp WHERE tp.CLIENT_SUPPLIER_ID = :clientSupplierId AND tp.NAME LIKE CONCAT('%', :SEARCH_KEYWORD, '%')")
    List<TbProducts> findAllByClientSupplierId(
            @Param("clientSupplierId") String clientSupplierId,
            @Param("SEARCH_KEYWORD") String SEARCH_KEYWORD,
            @Param("pageable") Pageable pageable);
}
