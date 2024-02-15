package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Jan 28, 2024
 */

@Entity
@Table(name = "car_list")
public class Car {
	@Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "MAKE")
    private String make;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "YEAR")
    private int year;

    // default, no-arg constructor
    public Car() {
        super();
    }

    /**
     * @param make
     * @param model
     * @param year
     */
    public Car(String make, String model, int year) {
        super();
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getter and setter methods
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
    
    // Helper method - print details
    public String returnCarDetails() {
        return this.make + " " + this.model + " " + this.year;
    }

	@Override
	public String toString() {
		return "Car [make=" + make + ", model=" + model + ", year=" + year + "]";
	}
    

}

