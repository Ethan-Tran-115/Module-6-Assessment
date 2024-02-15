package controller;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Jan 28, 2024
 */

public class CarHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarList");

    public void insertCar(Car car) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        em.close();
    }

    public List<Car> showAllCars() {
        EntityManager em = emfactory.createEntityManager();
        List<Car> allCars = em.createQuery("SELECT c FROM Car c").getResultList();
        em.close();
        return allCars;
    }

    public void deleteCar(Car toDelete) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Car> typedQuery = em.createQuery(
                "SELECT c FROM Car c WHERE c.make = :selectedMake AND c.model = :selectedModel",
                Car.class);

        typedQuery.setParameter("selectedMake", toDelete.getMake());
        typedQuery.setParameter("selectedModel", toDelete.getModel());

        typedQuery.setMaxResults(1);

        Car result = typedQuery.getSingleResult();
        em.remove(result);
        em.getTransaction().commit();
        em.close();
    }

    public void updateCar(Car toEdit) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public List<Car> searchForCarByMake(String make) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Car> typedQuery = em.createQuery(
                "SELECT c FROM Car c WHERE c.make = :selectedMake", Car.class);
        typedQuery.setParameter("selectedMake", make);
        List<Car> foundCars = typedQuery.getResultList();
        em.close();
        return foundCars;
    }

    public List<Car> searchForCarByModel(String model) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Car> typedQuery = em.createQuery(
                "SELECT c FROM Car c WHERE c.model = :selectedModel", Car.class);
        typedQuery.setParameter("selectedModel", model);
        List<Car> foundCars = typedQuery.getResultList();
        em.close();
        return foundCars;
    }

    public List<Car> searchForCarByYear(int year) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Car> typedQuery = em.createQuery(
                "SELECT c FROM Car c WHERE c.year = :selectedYear", Car.class);
        typedQuery.setParameter("selectedYear", year);
        List<Car> foundCars = typedQuery.getResultList();
        em.close();
        return foundCars;
    }
    
    
    public	Car searchForCarById(int idToEdit)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Car found = em.find(Car.class, idToEdit);
		em.close();
		return found;
		}
    
    public void cleanUp() {
        emfactory.close();
    }
}
