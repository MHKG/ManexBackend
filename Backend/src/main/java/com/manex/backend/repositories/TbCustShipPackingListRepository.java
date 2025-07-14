package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustShipPackingList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustShipPackingListRepository
        extends JpaRepository<TbCustShipPackingList, Integer>,
                JpaSpecificationExecutor<TbCustShipPackingList> {}
