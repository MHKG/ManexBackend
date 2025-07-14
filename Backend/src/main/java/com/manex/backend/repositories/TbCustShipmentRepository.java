package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustShipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustShipmentRepository
        extends JpaRepository<TbCustShipment, Integer>, JpaSpecificationExecutor<TbCustShipment> {}
