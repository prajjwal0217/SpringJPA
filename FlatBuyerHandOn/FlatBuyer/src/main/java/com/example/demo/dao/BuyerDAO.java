package com.example.demo.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Buyer;
import com.example.demo.bean.Flat;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.FlatRepository;


/*DAO - Data Access Object */
/*Used to abstract data access logic*/
@Component
public class BuyerDAO {
    
    @Autowired
    private BuyerRepository buyerRepo;

    @Autowired
    private FlatRepository flatRepo;

    /*save method is used to add the object of buyer class*/
    public void addBuyer(Buyer buyer){
        buyerRepo.save(buyer);
    }

    public void addFlat(String buyerId,Flat flat){
        /*Optional contains an object that may or may not contain a non-null value. */
        Optional<Buyer> op = buyerRepo.findById(buyerId);
        flat.setBuyer(op.get());
        flatRepo.save(flat);
    }
}
