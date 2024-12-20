package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyProductNumber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbCompanyProductNumberRepository
        extends JpaRepository<TbCompanyProductNumber, Integer>,
                JpaSpecificationExecutor<TbCompanyProductNumber> {

    @Query(
            "SELECT tcpn FROM TbCompanyProductNumber tcpn WHERE tcpn.id.PRODUCT_ID = :productId and tcpn.id.APP_CLIENT_ID = :appClientId")
    List<TbCompanyProductNumber> findByProductIdAndAppClientId(int productId, int appClientId);
}
