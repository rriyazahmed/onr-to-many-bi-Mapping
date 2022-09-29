package com.ty;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetrieveFoodOrderAndItems {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vikas");
		EntityManager em = emf.createEntityManager();
		FoodOrder foodOrder = em.find(FoodOrder.class, 1);
		if (foodOrder != null) {
			System.out.println("****** FoodOrder details ********");
			System.out.println("To : " + foodOrder.getToWhome());
			System.out.println("Status: " + foodOrder.getStatus());

			System.out.println("*******************************");
		}
		List<Item> items = foodOrder.getItems();
		if (items != null) {
			for (Item i : items) {
				System.out.println("******* Item details *************");
				System.out.println("ID is: " + i.getId());
				System.out.println("Name is: " + i.getName());
				System.out.println(" Quantity : " + i.getQuantity());
				System.out.println(" Cost : " + i.getCost());

			}
		}

	}

}
