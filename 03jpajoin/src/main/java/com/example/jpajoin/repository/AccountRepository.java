package com.example.jpajoin.repository;

import com.example.jpajoin.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends JpaRepository<AccountModel,Integer>,JpaSpecificationExecutor<AccountModel> {

    @Transactional
    @Modifying(clearAutomatically=true)
    @Query(value = "UPDATE `account` SET `username`=?1 WHERE `id`=?2 ", nativeQuery = true)
    int updateDate(String username, Integer id);

}
