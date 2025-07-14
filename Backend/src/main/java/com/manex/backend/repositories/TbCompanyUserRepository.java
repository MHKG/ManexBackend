package com.manex.backend.repositories;

import com.manex.backend.entities.TbCompanyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TbCompanyUserRepository
        extends JpaRepository<TbCompanyUser, Integer>, JpaSpecificationExecutor<TbCompanyUser> {

    @Query("SELECT cu FROM TbCompanyUser cu WHERE USER_ID = :id")
    List<TbCompanyUser> findAllByUSER_ID(Integer id);

    @Query(
            value =
                    "SELECT tup.*, cu.*, tc.NAME FROM tb_company_user cu LEFT JOIN tb_company tc on cu.COMPANY_ID = tc.id LEFT JOIN tb_user_profile tup on cu.USER_ID = tup.USER_ID WHERE cu.user_id = :id",
            nativeQuery = true)
    List<Map<String, Object>> findAllDataByUserId(Integer id);
}
