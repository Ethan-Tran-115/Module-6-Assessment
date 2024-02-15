package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Shopper;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Feb 14, 2024
 */
public class ShopperHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarList");
	public void insertShopper(Shopper s) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
    }
	
	public List<Shopper> showAllShoppers() {
        EntityManager em = emfactory.createEntityManager();
        List<Shopper> allShoppers = em.createQuery("SELECT s FROM Shopper s", Shopper.class).getResultList();
        em.close();
        return allShoppers;
    }
	
	public Shopper findShopper(String nameToLookUp) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Shopper> typedQuery = em.createQuery("SELECT sh FROM Shopper sh WHERE sh.shopperName = :selectedName", Shopper.class);
        typedQuery.setParameter("selectedName", nameToLookUp);
        typedQuery.setMaxResults(1);

        Shopper foundShopper;
        try {
            foundShopper = typedQuery.getSingleResult();
        } catch (NoResultException ex) {
            foundShopper = new Shopper(nameToLookUp);
        }

        em.close();

        return foundShopper;
    }
}
