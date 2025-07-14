package com.manex.backend.repositories;

import com.manex.backend.entities.TbClientSupplier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TbClientSupplierRepository
        extends JpaRepository<TbClientSupplier, Integer>,
                JpaSpecificationExecutor<TbClientSupplier> {

    @Query(
            "SELECT tcs FROM TbClientSupplier tcs LEFT JOIN TbCompany tc ON tcs.COMPANY_ID = tc.ID WHERE tcs.APP_CLIENT_ID = :APP_CLIENT_ID AND tc.NAME LIKE CONCAT('%', :SEARCH_KEYWORD, '%')")
    List<TbClientSupplier> findAllByAppClientIdAndSearchKeyword(
            @Param("APP_CLIENT_ID") String APP_CLIENT_ID,
            @Param("SEARCH_KEYWORD") String SEARCH_KEYWORD);

    @Query(
            "SELECT tcs FROM TbClientSupplier tcs WHERE tcs.APP_CLIENT_ID = :APP_CLIENT_ID AND tcs.COMPANY_ID = :COMPANY_ID")
    TbClientSupplier findByAppClientIdAndCompanyId(int APP_CLIENT_ID, Integer COMPANY_ID);
}
