/**
 * @author ${user} - ejmanning
 * CIS175 - Spring 2021
 * ${date}
 */

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ShoeOwner;

public class ShoeOwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UserShoeLists");
	
	public void insertShoeOwner(ShoeOwner s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ShoeOwner> showAllShoeOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<ShoeOwner> allShoeOwners = em.createQuery("SELECT s FROM ShoeOwner s").getResultList();
		return allShoeOwners;
	}

	public ShoeOwner findShoeOwners(String nameToLookUp) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ShoeOwner> typedQuery = em.createQuery("select sh from ShoeOwner sh where sh.ownerName = :selectedName", ShoeOwner.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		ShoeOwner foundShoeOwner;
		try {
			foundShoeOwner = typedQuery.getSingleResult();
		}
		catch (NoResultException ex) {
			foundShoeOwner = new ShoeOwner(nameToLookUp);
		}
		
		em.close();
		return foundShoeOwner;
		
	}
}
