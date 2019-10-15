package com.wowo.ffms.repository;

import com.wowo.ffms.entity.Account;
import com.wowo.ffms.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    List<Account> findAll();

    @Query(value = "select sum(amount) am,DATE_FORMAT(adate,'%Y-%m') tt FROM accounts as a " +
            "inner join items on items.type = :type and a.item_id = items.id and year(adate) = :year group by tt",nativeQuery = true)
    List<Map<String,Object>> findAllByType(@Param("type")Integer type,@Param("year")Integer year);

    @Query(value = "select sum(amount) am,DATE_FORMAT(adate,'%Y-%m') tt FROM accounts as a " +
            "inner join items on items.type = 1 and a.item_id = items.id and items.name = :name and year(adate) = :year group by tt",nativeQuery = true)
    List<Map<String,Object>> findAllByName(@Param("name")String name,@Param("year")Integer year);

    @Override
    List<Account> findAll(Sort sort);

    List<Account> findDistinctByItem_Type(int type);

    //List<Account> findAllByAdateBetween(Date startTime, Date endTime);

    Page<Account> findAllByAdateBetween(Date startTime, Date endTime, Pageable page);


    Account findAccountById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from accounts where id in (?1)",nativeQuery = true)
    void deleteBatch(Integer[] ids);
}
