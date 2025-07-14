package com.manex.backend.repositories;

import com.manex.backend.entities.TbCity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbCityRepository
        extends JpaRepository<TbCity, Integer>, JpaSpecificationExecutor<TbCity> {

    @Query(
            "SELECT tc FROM TbCity tc WHERE tc.DISTRICT_ID = :DISTRICT_ID AND tc.CITY LIKE %:searchKeyword%")
    List<TbCity> findAllByDistrictIdAndKeyword(int DISTRICT_ID, String searchKeyword);
}
