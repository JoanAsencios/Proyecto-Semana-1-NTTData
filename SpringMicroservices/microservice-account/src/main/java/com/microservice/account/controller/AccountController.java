package com.microservice.account.controller;

import com.microservice.account.model.Account;
import com.microservice.account.model.Transaction;
import com.microservice.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Account register(@RequestBody Account account){
        return accountService.register(account);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ArrayList<Account> getAll(){
        return accountService.getAll();
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
    public Account getById(@PathVariable long id){
        return accountService.getById(id);
    }

    @RequestMapping(value = "/depositar", method = RequestMethod.PUT)
    public void depositar(@RequestBody Transaction trx){
         accountService.depositar(trx);
    }

    @RequestMapping(value = "/retirar", method = RequestMethod.PUT)
    public void retirar(@RequestBody Transaction trx){
         accountService.retirar(trx);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
         accountService.delete(id);
    }

    @RequestMapping(value = "/search-by-client/{idClient}", method = RequestMethod.GET)
    public ArrayList<Account> getAccountByClient(long idClient){
        return accountService.getAccountByClient(idClient);
    }

}
