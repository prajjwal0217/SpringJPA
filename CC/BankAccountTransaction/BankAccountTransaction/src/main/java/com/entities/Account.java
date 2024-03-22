package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Provide necessary Annotation
@Entity
public class Account {
	
	//Provide necessary Annotation
	@Id
	private String accountNumber;
	private String holderName;
	private String phoneNumber;
	private String panNumber;
	private String accountType; //Savings or Current
	private double balanceAmount;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "accountObj")
	List<BankTransaction> transactions;
	
	public Account() {
		super();
	}

	public Account(String accountNumber, String holderName, String phoneNumber, String panNumber, String accountType,
			double balanceAmount) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.phoneNumber = phoneNumber;
		this.panNumber = panNumber;
		this.accountType = accountType;
		this.balanceAmount = balanceAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public List<BankTransaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}
	
	

	
}
