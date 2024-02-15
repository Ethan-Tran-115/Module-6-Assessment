import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.Car;
import model.ListDetails;
import model.Shopper;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Feb 14, 2024
 */
public class ListDetailsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shopper phuoc = new Shopper("Phuoc");

        ListDetailsHelper ldh = new ListDetailsHelper();

        Car car1 = new Car("Toyota", "Tundra", 2024);
        Car car2 = new Car("Honda", "CRV", 2022);

        List<Car> phuocCars = new ArrayList<>();
        phuocCars.add(car1);
        phuocCars.add(car2);

        ListDetails phuocList = new ListDetails("Phuoc's CarList", LocalDate.now(), phuoc);
        phuocList.setListOfCars(phuocCars);

        ldh.insertNewListDetails(phuocList);

        List<ListDetails> allLists = ldh.getLists();
        for (ListDetails list : allLists) {
            System.out.println(list.toString());
        }
	}

}
