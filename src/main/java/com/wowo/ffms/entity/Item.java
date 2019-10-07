package com.wowo.ffms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private int id;
    private int type;
    private String name;

    @ManyToOne
    @JoinColumn(name = "pid")
    private Item pid;

    @JsonIgnore
    @OneToMany(mappedBy = "pid")
    private List<Item> items = new ArrayList<>();

    public Item() {
    }

//    public Item(int type, String name,Integer pid, Item item) {
//        this.type = type;
//        this.name = name;
//        this.pid = pid;
//        this.item = item;
////        this.items = items;
//    }


    public Item(int type, String name, Item pid) {
        this.type = type;
        this.name = name;
        this.pid = pid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getPid() {
        return pid;
    }

    public void setPid(Item pid) {
        this.pid = pid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}
