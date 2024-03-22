package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Flat;

/*It acts as an interface between our application and the database*/
/*Application communicate with the repo to perform CRUD operation. */
/* The repo abstracts away the complexities of database operations. */
@Repository
public interface FlatRepository extends JpaRepository<Flat,String>{
    
    @Query("select f from Flat f where f.numberOfRooms=(select max(numberOfRooms) from Flat) and f.flatPrice = (select min(flatPrice) from Flat)")
    List<Flat> findFlatWIthMinPriceMaxRooms();
}
