package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetMobileSim {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		Mobile mobile = em.find(Mobile.class, 2);
		if (mobile != null) {
			System.out.println("****** Mobile details ********");
			System.out.println("Name is: " + mobile.getName());
			System.out.println("Cost is: " + mobile.getCost());
			System.out.println("Cost is: " + mobile.getSims());
			System.out.println("*******************************");
		}
		List<Sim> sims = mobile.getSims();
		if (sims != null) {
			for (Sim s : sims) {
				System.out.println("******* Sim details *************");
				System.out.println("ID is: " + s.getId());
				System.out.println("Name is: " + s.getName());
				System.out.println("Provider is: " + s.getProvider());
			}
		}

	}

}
