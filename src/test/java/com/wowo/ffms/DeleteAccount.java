package com.wowo.ffms;

import com.wowo.ffms.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteAccount {

    @Autowired
    AccountService accountService;

    @Test
    public void delete(){
        Integer[] ids = {31,32};
        accountService.deleteAccountById(ids);
    }
}
