package com.wowo.ffms;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Security {
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Test
    public void test1(){
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
        boolean b = passwordEncoder.matches("1234567", encode);
        System.out.println(b);

    }
}
