package com.nihal.hb.student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDetailsDAO {

	private static final int Stpercent = 0;

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("emp");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		javax.persistence.Query query=manager.createQuery("delete from StudentDetailsDTO where stpercent<50");
		int rows=query.executeUpdate();
		System.out.println("No of rows affected: "+rows);
		transaction.commit();
		manager.close();
		factory.close();
		}

	}


