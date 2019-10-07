package com.wowo.ffms.service;


import com.wowo.ffms.entity.User;
import com.wowo.ffms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public boolean canLogin(User user){
        String name = user.getName();
        User user1 = userRepository.findUserByName(name);
        if (user1 != null){
            boolean b = passwordEncoder.matches(user.getPwd(), user1.getPwd());
            //user1.getPwd().equals(user.getPwd())
            if (b){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    public Page<User> selectAllUser(Integer pn,Integer pageSize){
        Pageable pageable = PageRequest.of(pn, pageSize, Sort.Direction.ASC, "id");
        return userRepository.findAll(pageable);
    }

    public boolean checkUser(String name) {
        User user = userRepository.findUserByName(name);
        if (user == null){
            return true;
        }else {
            return false;
        }
    }

    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    public void deleteUserById(Integer[] ids){
        userRepository.deleteBatch(ids);
    }

    public User getUserByPhone(String phone) {
        return userRepository.findUserByPhone(phone);
    }
}
