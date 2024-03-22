package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.entities.Account;
import com.entities.BankTransaction;
import com.service.AccountServiceImpl;
import com.service.TransactionServiceImpl;

@SpringBootApplication
@EntityScan("com.entities")
@ComponentScan(basePackages="com.*")
@EnableJpaRepositories("com.repository")
public class BankAccountTransactionApplication implements CommandLineRunner{

	@Autowired
	AccountServiceImpl accountService;

	@Autowired
	TransactionServiceImpl transactionService;
	public static void main(String[] args) {
		SpringApplication.run(BankAccountTransactionApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception{
		Account acc = new Account("SAV123", "Rahul", "99999999999", "ABCDE1234F", "Savings", 150000);
		accountService.openAccount(acc);

		Account accObj = accountService.viewAccountByAccountNumber("SAV123");
		System.out.println(accObj.getHolderName());

		System.out.println("===================");
		Account accObj1 = accountService.updateAccountHolderPhoneNumber("SAV123", "7773153161");
		System.out.println(accObj1.getPhoneNumber());
		System.out.println(accObj1.getBalanceAmount());

		System.out.println("===================");
		BankTransaction transaction = new BankTransaction("T101", "12/02/2024", "Deposit", 1000);
		transactionService.insertTransaction(transaction, "SAV123");
		Account accObj2 = accountService.viewAccountByAccountNumber("SAV123");
		System.out.println(accObj2.getBalanceAmount());
	}

}
