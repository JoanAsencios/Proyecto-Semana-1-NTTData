package com.microservice.account.dao;

import com.microservice.account.model.Account;
import com.microservice.account.model.Transaction;

import java.util.ArrayList;

public interface AccountDao {

    Account register(Account account);
    ArrayList<Account> getAll();
    Account getById(long id);
    ArrayList<Account> getByIdClient(long idCliente);
    void depositar(Transaction trx);
    void retirar(Transaction trx);
    Account update(Account account);
    void delete(long id);

}
