package com.nihal.hb.student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysql.cj.Query;

public class DetailsReadDAO {

	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("emp");
		EntityManager manager=factory.createEntityManager();
		javax.persistence.Query query1= manager.createQuery("from StudentDetailsDTO");
		List<StudentDetailsDTO> liDTOs= query1.getResultList();
		for (StudentDetailsDTO stdtDTO : liDTOs) {
			System.out.println(stdtDTO.getStid()+" "+stdtDTO.getStName()+" "+stdtDTO.getStstream()+" "+stdtDTO.getStpercent()+" "+stdtDTO.getStphone()+" "+stdtDTO.getStage()+" "+stdtDTO.getStaddress());
		}
	}

}
