package com.microservice.account.service;

import com.microservice.account.dao.AccountDao;
import com.microservice.account.model.Account;
import com.microservice.account.model.Transaction;
import com.microservice.account.util.AccountExceptions.AccountAmountException;
import com.microservice.account.util.AccountExceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class AccountService {

    @Autowired
    AccountDao accountDao;

    public Account register(Account account) {
        //Validar que el saldo sea mayor a 0
        if(account.getSaldo() > 0){
            return accountDao.register(account);
        }else{
            throw new AccountAmountException("Saldo debe ser mayor a 0");
        }
    }

    public ArrayList<Account> getAll() {
        return accountDao.getAll();
    }

    public Account getById(long id) {
        return accountDao.getById(id);
    }

    public void depositar(Transaction trx) {
        Account account = getById(trx.getIdCuenta());
        double amount = 0;
        double saldo = 0;
        double newSaldo = 0;
        //Valida si existe la cuenta en la BD
            if(account != null){
                amount = trx.getAmount();
                saldo = account.getSaldo();
                newSaldo = amount + saldo;
                account.setSaldo(newSaldo);
                accountDao.update(account);
                accountDao.depositar(trx);
            }else{
                throw new AccountNotFoundException("Cuenta no registrada");
            }
    }

    public void retirar(Transaction trx) {
        Account account = getById(trx.getIdCuenta());
        double amount = 0;
        double saldo = 0;
        double newSaldo = 0;
        //Valida si existe la cuenta en la BD
        if(account != null){
            int tipoCuenta = account.getTipoCuenta();
            amount = trx.getAmount();
            saldo = account.getSaldo();
                if(amount <= saldo && tipoCuenta == 1){
                    newSaldo = saldo - amount;
                    account.setSaldo(newSaldo);
                    accountDao.update(account);
                    accountDao.depositar(trx);

                }else if(tipoCuenta == 2){
                    newSaldo = saldo - amount;
                        if(saldo > -500){
                            account.setSaldo(newSaldo);
                            accountDao.update(account);
                            accountDao.depositar(trx);
                        }else{
                            throw new AccountAmountException("Saldo no disponible");
                        }
                }else{
                    throw new AccountAmountException("Retiro no puede se mayor a saldo en cuenta de ahorros");
                }
        }else{
            throw new AccountNotFoundException("Cuenta no registrada");
        }
    }

    public void delete(long id) {
        accountDao.delete(id);
    }

    public ArrayList<Account> getAccountByClient(long idClient){
        ArrayList<Account> accounts = accountDao.getByIdClient(idClient);
            if(accounts != null){
                return accounts;
            }else{
                throw new AccountNotFoundException("Cuenta no registrada");
            }
    }
}
