package com.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Provide necessary Annotation
@Entity
public class BankTransaction {

	//Provide necessary Annotation
	@Id
	private String transactionId;
	private String transactionDate;
	private String transactionType;//Deposit or Withdraw
	private double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_number")
	@JsonIgnoreProperties("transactions")
	private Account accountObj;

	public BankTransaction() {
	}

	public BankTransaction(String transactionId, String transactionDate, String transactionType, double amount) {
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Account getAccountObj() {
		return accountObj;
	}

	public void setAccountObj(Account accountObj) {
		this.accountObj = accountObj;
	}	
}
