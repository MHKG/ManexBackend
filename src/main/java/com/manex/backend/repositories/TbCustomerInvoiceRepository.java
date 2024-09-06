package com.manex.backend.repositories;

import com.manex.backend.entities.TbCustomerInvoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbCustomerInvoiceRepository
        extends JpaRepository<TbCustomerInvoice, Integer>,
                JpaSpecificationExecutor<TbCustomerInvoice> {}
