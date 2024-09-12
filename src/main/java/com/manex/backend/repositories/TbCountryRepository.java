package com.manex.backend.repositories;

import com.manex.backend.entities.TbCountry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbCountryRepository
        extends JpaRepository<TbCountry, Integer>, JpaSpecificationExecutor<TbCountry> {

	@Query("SELECT tc FROM TbCountry tc WHERE COUNTRY LIKE CONCAT('%', :SEARCH_KEYWORD, '%')")
    List<TbCountry> findAllByKeyword(String SEARCH_KEYWORD);
}
