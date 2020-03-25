package com.example.demo.AccountDao;

import com.example.demo.AccountModel.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountDaoImplTest {
    private DriverManagerDataSource dataSource;
    private AccountDao dao;
    @BeforeEach
    void setupBeforeEach() {
        dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/accountdb ");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
         dao= new AccountDaoImpl(dataSource);
    }
    @Test
    void save() {
        Account account=new Account("James bonD","stev@gmail,com","0101" ,"718171811");
        int result=dao.save(account);
        assertTrue(result>0);
    }
    @Test
    void update() {
       Account account=new Account(2,"steepp otara","stev@gmail,com","cupertion,CA" ,"718171811");
        int result=dao.update(account);
        assertTrue(result>0) ;
    }

    @Test
    void contact() {
        Integer id=1;
        Account account=dao.get(id);
        if(account !=null)
        {
            System.out.println(account);
        }
        assertNotNull(account);
    }

    @Test
    void delete() {
        Integer id=2;
        int result=dao.delete(id) ;
        assertTrue(result>0);
    }

    @Test
    void list() {
        List<Account> contactList=dao.List();
        for( Account aContact:contactList){
            System.out.println(aContact);
        }
        assertTrue(!contactList.isEmpty());
    }
}