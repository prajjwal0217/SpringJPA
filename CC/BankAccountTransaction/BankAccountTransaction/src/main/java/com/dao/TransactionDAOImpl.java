package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Account;
import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;
import com.repository.AccountRepository;
import com.repository.TransactionRepository;

//Provide necessary Annotation
@Component
public class TransactionDAOImpl implements ITransactionDAO {
	
	//Provide code to Inject TransactionRepository and AccountRepository
	@Autowired
	TransactionRepository transactionRepository;
	//Provide code to Inject AccountRepository, if needed
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public BankTransaction insertTransaction(BankTransaction transactionObj,String accountNumber) throws InvalidBankTransactionException{
		
		//fill code
		Optional<Account> aObj = accountRepository.findById(accountNumber);
		if(aObj.isPresent()){
				Account acc = aObj.get();
				if(transactionObj.getTransactionType().equals("Deposit")){
					acc.setBalanceAmount(acc.getBalanceAmount()+transactionObj.getAmount());
				}else{
					acc.setBalanceAmount(acc.getBalanceAmount()-transactionObj.getAmount());
				}
				transactionObj.setAccountObj(acc);
				return transactionRepository.save(transactionObj);
		}else{
			throw new InvalidBankTransactionException();
		}
	}
	
	@Override
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException
	{	
		Optional<Account> accObj = accountRepository.findById(accountNumber);
		if(accObj.isPresent()){
			return transactionRepository.findByAccountObjAccountNumber(accountNumber);
		}else{
			throw new InvalidBankTransactionException();
		}	
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType)
	{
		return transactionRepository.findByTransactionType(transactionType);	
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType,double amount)
	{
		return transactionRepository.findByTransactionTypeAndAmountGreaterThanEqual(transactionType, amount);	
	}

}
