package com.wowo.ffms.repository;

import com.wowo.ffms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//<实体类，主键数据类型>
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByName(String name);

    List<User> findAll();

    User findUserById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from users where id in (?1)",nativeQuery = true)
    void deleteBatch(Integer[] ids);

    User findUserByPhone(String phone);

}
