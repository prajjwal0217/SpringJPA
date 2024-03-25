package com.example.demo.bean;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Buyer {

    @Id
    private String buyerId;
    private String buyerName;
    private String buyerContactNumber;

    /*Cascade is used for automaticallly performing operations on associated entities when an operate is performed on the parent entity*/
    /*mappedBy is used to define the owning side of a bidirectional relationship between entites*/
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "buyer")
    private List<Flat> flatList = new ArrayList<>();

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerContactNumber() {
        return buyerContactNumber;
    }

    public void setBuyerContactNumber(String buyerContactNumber) {
        this.buyerContactNumber = buyerContactNumber;
    }

    public List<Flat> getFlatList() {
        return flatList;
    }

    public void setFlatList(List<Flat> flatList) {
        this.flatList = flatList;
    }
}
