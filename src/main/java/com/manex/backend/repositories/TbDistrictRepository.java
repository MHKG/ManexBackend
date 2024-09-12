package com.manex.backend.repositories;

import com.manex.backend.entities.TbDistrict;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TbDistrictRepository
        extends JpaRepository<TbDistrict, Integer>, JpaSpecificationExecutor<TbDistrict> {

	@Query(
			"SELECT td FROM TbDistrict td WHERE td.STATE_ID = :State_Id AND td.DISTRICT LIKE %:searchKeyword%")
	List<TbDistrict> findAllByStateIdAndKeyword(int State_Id, String searchKeyword);
}
