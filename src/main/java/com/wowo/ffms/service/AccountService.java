package com.wowo.ffms.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wowo.ffms.entity.Account;
import com.wowo.ffms.entity.Item;
import com.wowo.ffms.repository.AccountRepository;
import com.wowo.ffms.repository.ItemRepository;
import com.wowo.ffms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ItemRepository itemRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public void edit(Account account) {
        accountRepository.save(account);
    }

    public Page<Account> getAllAccounts(Integer pn,Integer pageSize) {
//        PageHelper.startPage(pn,5);
        Pageable pageable = PageRequest.of(pn, pageSize, Sort.Direction.ASC, "id");
        return accountRepository.findAll(pageable);
//        PageInfo<Account> pageInfo = new PageInfo<>(accounts);
//        return pageInfo;
    }

    public Page<Account> findAll(Integer pn) {
        //PageRequest page = PageRequest.of(pn,5);
        Pageable page = PageRequest.of(pn, 5);
        return accountRepository.findAll(page);
    }

    public List<Map<String,Object>> findByMonth(Integer type,Integer year){
        return accountRepository.findAllByType(type,year);
    }


    public List<Map<String, Object>> findByItemName(String name, Integer year) {
        return accountRepository.findAllByName(name,year);
    }

    public List<Item> getAllByItemType(int type) {
        return itemRepository.findByType(type);
    }
//
//        public List<Account> findAccountByTime(Date startDate, Date endDate) {
//        return accountRepository.findAllByAdateBetween(startDate,endDate);
//
//    }


    public Page<Account> findAccountByTime(Integer pn,Date startDate, Date endDate) {
        Pageable page = PageRequest.of(pn, 5);
        return accountRepository.findAllByAdateBetween(startDate,endDate,page);

    }

    public Account getAccountById(Integer id) {
        return accountRepository.findAccountById(id);
    }



    public void deleteAccountById(Integer[] ids) {
        accountRepository.deleteBatch(ids);
    }
}
