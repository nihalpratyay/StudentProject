package com.nihal.hb.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

public class UpdateDetailsDAO {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("emp");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		
		javax.persistence.Query query=manager.createQuery("update StudentDetailsDTO set stpercent=stpercent+10");
		int rows=query.executeUpdate();
		System.out.println("No of rows affected: "+rows);
		System.out.println("Students Pecentage updated");
        transaction.commit();
        manager.close();
        factory.close();
	}

}
