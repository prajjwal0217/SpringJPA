package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.bean.Buyer;
import com.example.demo.bean.Flat;
import com.example.demo.dao.BuyerDAO;

@SpringBootApplication
public class FlatBuyerApplication implements CommandLineRunner{

	@Autowired
	BuyerDAO buyerDAO;

	public static void main(String[] args) {
		SpringApplication.run(FlatBuyerApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception{
		System.out.println("Invoke the methods");
		Buyer buyer = new Buyer();
		buyer.setBuyerId("B1");
		buyer.setBuyerName("Prajjwal");
		buyer.setBuyerContactNumber("7773153161");
		buyerDAO.addBuyer(buyer);

		Flat flat = new Flat();
		flat.setFlatId("F1");
		flat.setFlatPrice(20000);
		flat.setDoorNumber(12);
		flat.setFlatArea(2000);
		flat.setFlatType("Single");
		flat.setNumberOfRooms(6);
		buyerDAO.addFlat("B1", flat);

	}

}
