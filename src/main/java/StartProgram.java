import java.util.List;
import java.util.Scanner;
import controller.CarHelper;
import model.Car;

/**
 * @author Phuoc Tran - ptran9@dmacc.edu
 * CIS175 - Spring 2024
 * Jan 28, 2024
 */

public class StartProgram {
	static Scanner in = new Scanner(System.in);
    static CarHelper carHelper = new CarHelper();

    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        boolean goAgain = true;
        System.out.println("--- Welcome to Car List Program! ---");
        while (goAgain) {
            System.out.println("* Select an option:");
            System.out.println("1 - Add a new car");
            System.out.println("2 - Edit a car");
            System.out.println("3 - Delete a car");
            System.out.println("4 - View all cars");
            System.out.println("5 - Exit the program");
            System.out.print("Your selection: ");
            int selection = in.nextInt();
            in.nextLine(); 

            if (selection == 1) {
                addCar();
            } else if (selection == 2) {
                editCar();
            } else if (selection == 3) {
                deleteCar();
            } else if (selection == 4) {
                viewAllCars();
            } else if (selection == 5) {
                carHelper.cleanUp();
                System.out.println("Goodbye!");
                goAgain = false;
            } else {
                System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void addCar() {
        System.out.print("Enter the make of the car: ");
        String make = in.nextLine();
        System.out.print("Enter the model of the car: ");
        String model = in.nextLine();
        System.out.print("Enter the year of the car: ");
        int year = in.nextInt();

        Car carToAdd = new Car(make, model, year);
        carHelper.insertCar(carToAdd);
    }

    private static void deleteCar() {
        System.out.print("Enter the make of the car to delete: ");
        String make = in.nextLine();
        System.out.print("Enter the model of the car to delete: ");
        String model = in.nextLine();
        System.out.print("Enter the year of the car to delete: ");
        int year = in.nextInt();
        in.nextLine();

        Car carToDelete = new Car(make, model, year);
        carHelper.deleteCar(carToDelete);
    }

    private static void editCar() {
    	System.out.println("How would you like to search?");
        System.out.println("1 : Search by Make");
        System.out.println("2 : Search by Model");
        System.out.println("3 : Search by Year");
        int searchBy = in.nextInt();
        in.nextLine(); 
        List<Car> foundCars;

        if (searchBy == 1) {
            System.out.print("Enter the make of the car: ");
            String make = in.nextLine();
            foundCars = carHelper.searchForCarByMake(make);
        } else if (searchBy == 2) {
            System.out.print("Enter the model of the car: ");
            String model = in.nextLine();
            foundCars = carHelper.searchForCarByModel(model);
        } else {
            System.out.print("Enter the year of the car: ");
            int year = in.nextInt();
            in.nextLine();
            foundCars = carHelper.searchForCarByYear(year);
        }

        if (!foundCars.isEmpty()) {
            System.out.println("Found Results:");
            for (Car car : foundCars) {
                System.out.println(car.returnCarDetails());
            }

            System.out.print("Enter the index of the car to edit: ");
            int indexToEdit = in.nextInt();
            in.nextLine(); 

            if (indexToEdit >= 0 && indexToEdit < foundCars.size()) {
                Car carToEdit = foundCars.get(indexToEdit);
                System.out.println("Retrieved " + carToEdit.returnCarDetails());
                System.out.println("1 : Update Make");
                System.out.println("2 : Update Model");
                System.out.println("3 : Update Year");
                System.out.print("Your selection: ");
                int update = in.nextInt();
                in.nextLine(); 

                if (update == 1) {
                    System.out.print("Enter the new make: ");
                    String newMake = in.nextLine();
                    carToEdit.setMake(newMake);
                } else if (update == 2) {
                    System.out.print("Enter the new model: ");
                    String newModel = in.nextLine();
                    carToEdit.setModel(newModel);
                } else if (update == 3) {
                    System.out.print("Enter the new year: ");
                    int newYear = in.nextInt();
                    in.nextLine(); 
                    carToEdit.setYear(newYear);
                }

                carHelper.updateCar(carToEdit);
                System.out.println("Car updated successfully!");
            } else {
                System.out.println("Invalid index. Please try again.");
            }
        } else {
            System.out.println("No results found");
        }
    }

    private static void viewAllCars() {
        List<Car> allCars = carHelper.showAllCars();
        for (Car singleCar : allCars) {
            System.out.println(singleCar.returnCarDetails());
        }
    }
}
