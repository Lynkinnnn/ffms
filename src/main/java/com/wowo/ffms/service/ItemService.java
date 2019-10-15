package com.wowo.ffms.service;

import com.wowo.ffms.entity.Account;
import com.wowo.ffms.entity.Item;
import com.wowo.ffms.entity.User;
import com.wowo.ffms.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getParent(){

        return itemRepository.findAllByPidIsNull();
    }

    public List<Item> getChild(Integer id){
        return itemRepository.findAllByPid_Id(id);
    }

    public Page<Item> getAllItems(Integer pn,Integer pageSize) {
        Pageable pageable = PageRequest.of(pn, pageSize, Sort.Direction.ASC, "id");
        return itemRepository.findAll(pageable);
    }

    public boolean checkItem(Item item){
        Item item1 = itemRepository.findByPid_IdAndName(item.getPid().getId(), item.getName());
        if (item1 == null){
            return true;
        }else {
            return false;
        }
    }


    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    public Item getItemById(Integer id) {
        return itemRepository.findItemById(id);
    }

    public void deleteItemById(Integer[] ids) {
        itemRepository.deleteBatch(ids);
    }
}
