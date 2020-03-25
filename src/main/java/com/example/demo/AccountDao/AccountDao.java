package com.example.demo.AccountDao;

import com.example.demo.AccountModel.Account;

import java.util.List;

public interface AccountDao {
    public int save(Account account);
    public int update( Account account);
    public  Account get(Integer id);
    public int delete (Integer id);
    public List<Account> List();
}
