package com.manex.backend.repositories;

import com.manex.backend.entities.TbDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbDistrictRepository
        extends JpaRepository<TbDistrict, Integer>, JpaSpecificationExecutor<TbDistrict> {}
