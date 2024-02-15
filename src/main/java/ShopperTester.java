import java.util.List;

import controller.ShopperHelper;
import model.Shopper;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Feb 14, 2024
 */
public class ShopperTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shopper phuoc = new Shopper("Phuoc");
        ShopperHelper sh = new ShopperHelper();
        sh.insertShopper(phuoc);
        
        Shopper Anna = new Shopper("Anna");
        sh.insertShopper(Anna);
        
        List<Shopper> allShoppers = sh.showAllShoppers();
        for (Shopper shopper : allShoppers) {
            System.out.println(shopper.toString());
        }
	}

}
