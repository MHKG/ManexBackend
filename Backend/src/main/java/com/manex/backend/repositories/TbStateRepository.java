package com.manex.backend.repositories;

import com.manex.backend.entities.TbState;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TbStateRepository
        extends JpaRepository<TbState, Integer>, JpaSpecificationExecutor<TbState> {

    @Query(
            "SELECT ts FROM TbState ts WHERE ts.COUNTRY_ID = :countryId AND ts.STATE LIKE %:searchKeyword%")
    List<TbState> findAllByCountryIdAndKeyword(
            @Param("countryId") int countryId, @Param("searchKeyword") String searchKeyword);
}
