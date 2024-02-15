package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Feb 14, 2024
 */
@Entity
@Table(name = "shoppers")
public class Shopper {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String shopperName;

    public Shopper() {
        // Default constructor
    }

    public Shopper(int id, String shopperName) {
        this.id = id;
        this.shopperName = shopperName;
    }

    public Shopper(String shopperName) {
        this.shopperName = shopperName;
    }

    // Getter and setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopperName() {
        return shopperName;
    }

    public void setShopperName(String shopperName) {
        this.shopperName = shopperName;
    }

    // Additional methods, if needed

    @Override
    public String toString() {
        return "Shopper [id=" + id + ", shopperName=" + shopperName + "]";
    }
}
