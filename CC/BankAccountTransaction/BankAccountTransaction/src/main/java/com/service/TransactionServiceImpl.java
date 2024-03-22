package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ITransactionDAO;
import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;

//Provide necessary Annotation
@Service
public class TransactionServiceImpl implements ITransactionService {

	//Provide necessary Annotation
	@Autowired
	ITransactionDAO transactionDAO;

	public TransactionServiceImpl(ITransactionDAO transactionDAO){
		this.transactionDAO = transactionDAO;
	}
	@Override
	public BankTransaction insertTransaction(BankTransaction transactionObj,String accountNumber)  throws InvalidBankTransactionException 
	{
		return transactionDAO.insertTransaction(transactionObj, accountNumber);
	}
	
	@Override
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException
	{		
		return transactionDAO.viewTransactionByAccountNumber(accountNumber);
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType)
	{
		return transactionDAO.viewTransactionByTransactionType(transactionType);
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType,double amount)
	{
		return transactionDAO.viewTransactionByTransactionTypeAndAmount(transactionType, amount);
	}

}
