package com.wowo.ffms;

import com.wowo.ffms.controller.AccountController;
import com.wowo.ffms.entity.Account;
import com.wowo.ffms.repository.AccountRepository;
import com.wowo.ffms.repository.ItemRepository;
import com.wowo.ffms.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;

public class FindByTime {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AccountRepository accountRepository;


    @Autowired
    AccountService accountService;

    @Autowired
    AccountController accountController;
    //@Test
    public List<Account> findByMonth(){
        return accountRepository.findAll();
    }

    @Test
    public void getAll(){
        List<Account> all = findByMonth();
        for (Account account : all) {
            System.out.println(account);
        }
    }

}
