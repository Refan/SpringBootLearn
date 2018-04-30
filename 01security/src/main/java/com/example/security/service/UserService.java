package com.example.security.service;

import com.example.security.model.AccountModel;
import com.example.security.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AccountModel accountModel = accountRepository.findByUsername(username);
        if(accountModel == null){
            throw new UsernameNotFoundException("not found");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(accountModel.getRole()));
        System.out.println("username:"+username+", role:"+accountModel.getRole());
        return new org.springframework.security.core.userdetails.User(accountModel.getUsername(), accountModel.getPassword(), authorities);
    }
}
