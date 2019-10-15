package com.wowo.ffms.repository;

import com.wowo.ffms.entity.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    //@Query(name = "getParent",value="select new Item(i.id,i.type,i.name,i.pid) from items i where i.pid is null ")
    List<Item> findAllByPidIsNull();

//    @Query("select i from items i where i.pid = ?1")
//    List<Item> findByPid(int id);

    //@Query(name = "findAllByPid",value="select id,name from items where pid =:id")
    List<Item> findAllByPid_Id(@Param("id") Integer id);

    Item findByPid_IdAndName(@Param("pid")Integer pid,@Param("name")String itemName);

    List<Item> findByType(Integer Type);

    Item findItemById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from items where id in (?1)",nativeQuery = true)
    void deleteBatch(Integer[] ids);

}
