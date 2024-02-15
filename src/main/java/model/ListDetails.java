package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Feb 14, 2024
 */

@Entity
public class ListDetails {
	@Id
    @GeneratedValue
	private int id;
    private String listName;
    private LocalDate tripDate;
    @ManyToOne (cascade=CascadeType.PERSIST)
    private Shopper shopper;
    @OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
    private List<Car> listOfCars;

    public ListDetails() {
        // Default constructor
    }

    public ListDetails(int id, String listName, LocalDate tripDate, Shopper shopper, List<Car> listOfCars) {
        this.id = id;
        this.listName = listName;
        this.tripDate = tripDate;
        this.shopper = shopper;
        this.listOfCars = listOfCars;
    }

    public ListDetails(String listName, LocalDate tripDate, Shopper shopper, List<Car> listOfCars) {
        this.listName = listName;
        this.tripDate = tripDate;
        this.shopper = shopper;
        this.listOfCars = listOfCars;
    }

    public ListDetails(String listName, LocalDate tripDate, Shopper shopper) {
        this.listName = listName;
        this.tripDate = tripDate;
        this.shopper = shopper;
    }

    // Getter and setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public LocalDate getTripDate() {
        return tripDate;
    }

    public void setTripDate(LocalDate tripDate) {
        this.tripDate = tripDate;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    public List<Car> getListOfCars() {
        return listOfCars;
    }

    public void setListOfCars(List<Car> listOfCars) {
        this.listOfCars = listOfCars;
    }

    // Additional methods, if needed

    @Override
    public String toString() {
        return "ListDetails [id=" + id + ", listName=" + listName + ", tripDate=" + tripDate + ", shopper=" + shopper
                + ", listOfCars=" + listOfCars + "]";
    }
}
