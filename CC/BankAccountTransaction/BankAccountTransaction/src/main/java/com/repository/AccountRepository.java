package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Account;

//Provide necessary Annotation
@Repository
public interface AccountRepository extends JpaRepository<Account,String>{
	
	List<Account> findByBalanceAmountGreaterThanEqual(double balance);
	//Provide necessary method to view Account with balance greater than or equal to a value 

}