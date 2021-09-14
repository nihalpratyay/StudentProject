package com.nihal.hb.student;

import java.math.BigInteger;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInsertDAO {
	public static void main(String[] args) {
	try {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("emp");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter Your name: ");
	String name=scanner.nextLine();
	System.out.println("Enter your Stream: ");
	String stream=scanner.next();
	System.out.println("Enter your Mark's percentage: ");
	int percent=scanner.nextInt();
	System.out.println("Enter your Phone number: ");
	BigInteger phone=scanner.nextBigInteger();
	System.out.println("Enter your age: ");
	int age=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter your address: ");
	String address=scanner.nextLine();
	
	StudentDetailsDTO dto= new StudentDetailsDTO();
	dto.setStName(name);
	dto.setStstream(stream);
	dto.setStpercent(percent);
	dto.setStphone(phone);
	dto.setStage(age);
	dto.setStaddress(address);
	manager.persist(dto);
	transaction.commit();
	manager.close();
	factory.close();
	System.out.println("Your data has been inserted");
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	

	
}	

}
