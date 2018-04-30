package com.example.security.repository;

import com.example.security.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Integer> {

    AccountModel findByUsername(String username);
}
