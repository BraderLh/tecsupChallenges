package Practica.semanaDos.practica2.ejer13.domain.core;

import Practica.semanaDos.practica2.ejer13.domain.models.Customer;
import Practica.semanaDos.practica2.ejer13.domain.models.Movie;
import Practica.semanaDos.practica2.ejer13.domain.models.RentalItem;

import javax.swing.text.html.CSS;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MovieRentalSystem {
    private final String name;
    private List<RentalItem> rentalItems;
    private List<Customer> customers;
    private boolean isSuccess;

    public MovieRentalSystem(String name) {
        this.name = name;
        this.rentalItems = new ArrayList<>();
        this.customers = new Stack<>();
    }

    public String getName() {
        return name;
    }

    public boolean addItem(RentalItem rentalItem) {
        assert rentalItem!=null;
        return this.isSuccess = this.rentalItems.add(rentalItem);
    }
    public boolean deleteItem(int id) {
        RentalItem deletedRentalItem = null;
        if (id>=0) {
            for (RentalItem rentalItem : this.rentalItems) {
                if (rentalItem.getIdItem() == id) {
                    deletedRentalItem = rentalItem;
                    break;
                }
            }
            assert deletedRentalItem != null;
            this.isSuccess = this.rentalItems.remove(deletedRentalItem);
        }
        return this.isSuccess;
    }

    public RentalItem searchItem(String itemName) {
        RentalItem foundRentalItem = null;
        for (RentalItem rentalItem : rentalItems) {
            if (rentalItem.getItemName().equals(itemName)) {
                foundRentalItem = rentalItem;
                break;
            }
        }
        return foundRentalItem;
    }
    public Customer getCustomer(String dni) {
        Customer foundCustomer = null;
        if (!dni.isEmpty()) {
            for (Customer customer : customers) {
                if (customer.getDni().equals(dni)) {
                    foundCustomer = customer;
                    break;
                }
            }
        }
        return foundCustomer;
    }

    public boolean registerCustomer(Customer customer) {
        assert customer != null;
        return this.isSuccess = customers.add(customer);
    }

    public boolean deleteCustomer(String dni) {
        Customer deletedCustomer = getCustomer(dni);
        if (deletedCustomer == null) {
            return this.isSuccess = false;
        } else {
            return this.isSuccess = customers.remove(deletedCustomer);
        }
    }
    public boolean rentMovieToCustomer(String movieName, String dni) {
        RentalItem rentalItem = searchItem(movieName);
        Customer customer = getCustomer(dni);
        if (rentalItem != null) {
            if(customer != null) {
                rentalItem.setAvailable(false);
                if(customer.getRentedMovies().contains(rentalItem)) {
                    System.out.println("You can't add this movie because is already in his/her list");
                    this.isSuccess = false;
                }else {
                    customer.addRentedMovies((Movie) rentalItem);
                    this.isSuccess = true;
                }
            }
            else {
                System.out.println("Error: Customer not exists");
                this.isSuccess = false;
            }
        } else {
            System.out.println("Error: Item not exists");
            this.isSuccess = false;
        }
        return this.isSuccess;
    }

    public void showAllRentItems() {
        System.out.println("***************** Showing rent items *****************");
        if (this.rentalItems.isEmpty()) {
            System.out.println("Fail: The rent item list is empty");
        } else {
            for (RentalItem rentalItem : this.rentalItems) {
                System.out.println(rentalItem.showDetails());
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    public void showAllCustomers() {
        System.out.println("***************** Showing customers *****************");
        if (this.customers.isEmpty()) {
            System.out.println("Fail: The customer list is empty");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer.showCustomerDetails());
            }
            System.out.println("--------------------------------------------------------");
        }
    }

    public void showItemsRentedByCustomer(String dni) {
        Customer customer = getCustomer(dni);
        if (customer == null) {
            System.out.println("Error: Customer not exists!");
        }
        else {
            List<Movie> movies = customer.getRentedMovies();
            System.out.println("***************** Showing rented items by customer *****************");
            if (movies.isEmpty()) {
                System.out.println("The rented movie list by user is empty");
            } else {
                for (Movie movie : movies) {
                    System.out.println(movie.showDetails());
                }
                System.out.println("--------------------------------------------------------");
            }
        }
    }
}
