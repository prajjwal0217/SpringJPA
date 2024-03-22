package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Account;
import com.exception.InvalidAccountException;
import com.repository.AccountRepository;

//Provide necessary Annotation
@Component
public class AccountDAOImpl implements IAccountDAO{
	
	//Provide code to Inject AccountRepository
	@Autowired
	AccountRepository accountRepository;

	@Override
	public Account openAccount(Account account) {
		return accountRepository.save(account);
	}
	
	@Override
	public Account updateAccountHolderPhoneNumber(String accountNumber,String phoneNumber) throws InvalidAccountException {
		Optional<Account> aObj = accountRepository.findById(accountNumber);
		if(aObj.isPresent()){
			Account acc = aObj.get();
			acc.setPhoneNumber(phoneNumber);
			return acc;
		}else{
			throw new InvalidAccountException();
		}
	}
	
	@Override
	public Account viewAccountByAccountNumber(String accountNumber) throws InvalidAccountException {
		Optional<Account> aObj = accountRepository.findById(accountNumber);
		if(aObj.isPresent()){
			return aObj.get();
		}else{
			throw new InvalidAccountException();
		}	
	}

	@Override
	public List<Account> viewAccountByBalance(double balance) {
		return accountRepository.findByBalanceAmountGreaterThanEqual(balance);
	}

}
