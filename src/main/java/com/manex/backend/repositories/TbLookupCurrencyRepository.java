package com.manex.backend.repositories;

import com.manex.backend.entities.TbLookupCurrency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbLookupCurrencyRepository
        extends JpaRepository<TbLookupCurrency, Integer>,
                JpaSpecificationExecutor<TbLookupCurrency> {

    @Query(
            "SELECT tlc FROM TbLookupCurrency tlc WHERE tlc.CURRENCY LIKE CONCAT ('%', :searchKeyword,'%')")
    List<TbLookupCurrency> findAllBySearchKeyword(String searchKeyword);
}
