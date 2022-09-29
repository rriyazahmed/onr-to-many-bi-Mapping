package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {

	public static void main(String[] args) {

		Mobile mobile = new Mobile();
		mobile.setName("Nokia");
		mobile.setCost(25000);

		Sim sim1 = new Sim();
		sim1.setName("Tata Sim");
		sim1.setProvider("Docomo");

		Sim sim2 = new Sim();
		sim2.setName("Air Sim");
		sim2.setProvider("Airtel");
		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);
		mobile.setSims(sims);
		sim1.setMobile(mobile);
		sim2.setMobile(mobile);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(mobile);
		em.persist(sim1);
		em.persist(sim2);
		et.commit();

	}

}
