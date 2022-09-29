package com.ty;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveFoodOrderItem {
	public static void main(String[] args) {
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setToWhome("Riyaz, Bengaluru");
		foodOrder.setStatus("Order placed");

		Item item1 = new Item();
		item1.setName("EarPhones");
		item1.setCost(200);
		item1.setQuantity(1);

		Item item2 = new Item();
		item2.setName("BackPack");
		item2.setCost(800);
		item2.setQuantity(1);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		foodOrder.setItems(items);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(foodOrder);
		em.persist(item1);
		em.persist(item2);
		et.commit();

	}

}
