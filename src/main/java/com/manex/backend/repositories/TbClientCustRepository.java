package com.manex.backend.repositories;

import com.manex.backend.entities.TbClientCust;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbClientCustRepository
        extends JpaRepository<TbClientCust, Integer>, JpaSpecificationExecutor<TbClientCust> {

    @Query(
            "SELECT tcc FROM TbClientCust tcc LEFT JOIN TbCompany tc ON tcc.COMPANY_ID = tc.ID WHERE tcc.APP_CLIENT_ID = :APP_CLIENT_ID AND tc.NAME LIKE CONCAT('%', :SEARCH_KEYWORD, '%')")
    List<TbClientCust> findAllByAppClientIdAndSearchKeyword(
            String APP_CLIENT_ID, String SEARCH_KEYWORD);
}
