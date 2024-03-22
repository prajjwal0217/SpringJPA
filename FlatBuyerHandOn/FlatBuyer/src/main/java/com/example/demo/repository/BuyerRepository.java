package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Buyer;

/*It acts as an interface between our application and the database*/
/*Application communicate with the repo to perform CRUD operation. */
/* The repo abstracts away the complexities of database operations. */
@Repository
public interface BuyerRepository extends JpaRepository<Buyer,String>{
    
}
