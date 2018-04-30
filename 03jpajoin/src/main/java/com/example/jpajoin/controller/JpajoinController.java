package com.example.jpajoin.controller;

import com.example.jpajoin.model.AccountModel;
import com.example.jpajoin.repository.AccountRepository;
import com.example.jpajoin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jpajoin")
public class JpajoinController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping("/index")
    @ResponseBody
    public String indexMain(){

        List<AccountModel> list = accountService.getAccount();

        String res = "";
        for (AccountModel accountModel:list){
            res = res + accountModel.toString() + "<br/>";
        }

        return res;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String updateMain(){
        AccountModel accountModel = accountRepository.getOne(1);
        accountModel.setUsername("admin");
        accountService.updateAccount(accountModel);
        return "success";
    }

}
