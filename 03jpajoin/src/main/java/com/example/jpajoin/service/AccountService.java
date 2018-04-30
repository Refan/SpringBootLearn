package com.example.jpajoin.service;

import com.example.jpajoin.model.AccountModel;
import com.example.jpajoin.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<AccountModel> getAccount(){
        return accountRepository.findAll();
    }

    public void updateAccount(AccountModel accountModel){
        accountRepository.save(accountModel);
    }

}
