package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IAccountDAO;
import com.entities.Account;
import com.exception.InvalidAccountException;

//Provide necessary Annotation
@Service
public class AccountServiceImpl implements IAccountService {
	
	
	//Provide necessary Annotation
	@Autowired
	IAccountDAO accountDAO;

	public AccountServiceImpl(IAccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	@Override
	public Account openAccount(Account account) {
		return accountDAO.openAccount(account);
	}
	
	@Override
	public Account updateAccountHolderPhoneNumber(String accountNumber,String phoneNumber) throws InvalidAccountException {
		return accountDAO.updateAccountHolderPhoneNumber(accountNumber, phoneNumber);
	}
	
	@Override
	public Account viewAccountByAccountNumber(String accountNumber) throws InvalidAccountException {
		return accountDAO.viewAccountByAccountNumber(accountNumber);		
	}
	
	@Override
	public List<Account> viewAccountByBalance(double balance) {
		return accountDAO.viewAccountByBalance(balance);
	}
}
