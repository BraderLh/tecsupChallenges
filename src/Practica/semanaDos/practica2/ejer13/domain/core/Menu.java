package Practica.semanaDos.practica2.ejer13.domain.core;

import Practica.semanaDos.practica2.ejer13.domain.models.Customer;
import Practica.semanaDos.practica2.ejer13.domain.models.Movie;
import Practica.semanaDos.practica2.ejer13.domain.models.RentalItem;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public String menuTitle(String objectName) {
        return "******** Welcome to " + objectName + " menu ********\n";
    }

    public String optionsMenuTxt() {
        String option1 = "Insert 1 to add an item\n";
        String option2 = "Insert 2 to delete an item\n";
        String option3 = "Insert 3 to show all items\n";
        String option4 = "Insert 4 to register a customer\n";
        String option5 = "Insert 5 to delete a customer\n";
        String option6 = "Insert 6 to show all costumer\n";
        String option7 = "Insert 7 to rent a movie\n";
        String option8 = "Insert 8 to show the rented movies by user\n";
        String option9 = "Insert 9 to exit";
        return option1+option2+option3+option4+option5+option6+option7+option8+option9;
    }

    public Movie dataForItem() {
        String[] arrayData = new String[5];
        System.out.print("Input movie name: ");
        arrayData[0] = scanner.nextLine();
        System.out.print("Input director name: ");
        arrayData[1] = scanner.nextLine();
        System.out.print("Input the duration: ");
        arrayData[2] = scanner.nextLine();
        System.out.print("Input the age rating: ");
        arrayData[3] = scanner.nextLine();
        System.out.print("Input the genre: ");
        arrayData[4] = scanner.nextLine();
        return new Movie(arrayData[0], arrayData[1], Short.parseShort(arrayData[2]), Short.parseShort(arrayData[3]), arrayData[4]);
    }

    public Customer dataForCustomer() {
        String[] arrayData2 = new String[5];
        System.out.print("Input DNI: ");
        arrayData2[0] = scanner.nextLine();
        System.out.print("Input customer name: ");
        arrayData2[1] = scanner.nextLine();
        System.out.print("Input customer surname: ");
        arrayData2[2] = scanner.nextLine();
        return new Customer(arrayData2[0], arrayData2[1], arrayData2[2]);
    }

    public boolean menuOptions(int option, MovieRentalSystem movieRentalSystem) {
        String confirmOp;
        String dni;
        int id = 0;
        boolean flag = true;

        switch (option) {
            case 1:
                RentalItem rentalItem = dataForItem();
                confirmOp = movieRentalSystem.addItem(rentalItem) ? "Adding successful! " :  "Adding was failed!";
                System.out.println(confirmOp);
                break;
            case 2:
                System.out.println("Input an id: ");
                id = scanner.nextInt();
                confirmOp = movieRentalSystem.deleteItem(id) ? "Deleting successful! " :  "Deleting was failed!";
                System.out.println(confirmOp);
                break;
            case 3:
                System.out.println("The movies are: ");
                movieRentalSystem.showAllRentItems();
                break;
            case 4:
                System.out.println("Enter the following information: ");
                Customer customer = dataForCustomer();
                confirmOp = movieRentalSystem.registerCustomer(customer) ? "Adding successful! " :  "Adding was failed!";
                System.out.println(confirmOp);
                break;
            case 5:
                System.out.println("Input the dni to delete: ");
                dni = scanner.nextLine().trim();
                if (dni.length()>8) {
                    dni = dni.substring(0,8);
                }
                confirmOp = movieRentalSystem.deleteCustomer(dni) ? "Deleting successful! " :  "Deleting was failed!";
                System.out.println(confirmOp);
                break;
            case 6:
                movieRentalSystem.showAllCustomers();
                break;
            case 7:
                System.out.println("Movie name for renting: ");
                String movieName = scanner.nextLine();
                System.out.println("DNI's customer for renting: ");
                dni = scanner.nextLine();
                if (dni.length()>8) {
                    dni = dni.substring(0,8);
                }
                confirmOp = movieRentalSystem.rentMovieToCustomer(movieName, dni) ? "Renting successful! " : "Renting was failed!";
                System.out.println(confirmOp);
                break;
            case 8:
                System.out.println("Enter the DNI's customer: ");
                dni = scanner.nextLine();
                movieRentalSystem.showItemsRentedByCustomer(dni);
                break;
            case 9:
                flag = false;
                break;
            default:
                System.out.println("Incorrect option");
        }
        return flag;
    }
}
