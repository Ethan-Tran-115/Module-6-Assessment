package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListDetails;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Feb 14, 2024
 */
public class ListDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarList");
	
	public void insertNewListDetails(ListDetails listDetails) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(listDetails);
        em.getTransaction().commit();
        em.close();
    }
	
	public List<ListDetails> getLists() {
        EntityManager em = emfactory.createEntityManager();
        List<ListDetails> allLists = em.createQuery("SELECT l FROM ListDetails l").getResultList();
        em.close();
        return allLists;
    }
	
	public void deleteList(ListDetails toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListDetails> typedQuery = em.createQuery("SELECT l FROM ListDetails l WHERE l.id = :selectedId", ListDetails.class);
        typedQuery.setParameter("selectedId", toDelete.getId());
        typedQuery.setMaxResults(1);
        ListDetails result = typedQuery.getSingleResult();
        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }
	public void updateList(ListDetails toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }
	
	public ListDetails searchForListDetailsById(int idToEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        ListDetails found = em.find(ListDetails.class, idToEdit);
        em.close();
        return found;
    }
}
