package Practica.semanaDos.practica2.ejer13.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final int idCustomer;
    private String dni;
    private String name;
    private String surname;

    private static int counterCustomer;
    private List<Movie> rentedMovies;

    public Customer(String dni, String name, String surname) {
        this.idCustomer = ++Customer.counterCustomer;
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.rentedMovies = new ArrayList<>();
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static int getCounterCustomer() {
        return counterCustomer;
    }

    public static void setCounterCustomer(int counterCustomer) {
        Customer.counterCustomer = counterCustomer;
    }

    public List<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(List<Movie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }

    public void addRentedMovies(Movie movie) {
        assert movie != null;
        movie.setAvailable(false);
        this.rentedMovies.add(movie);
    }
    public String showCustomerDetails() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", rentedMovies=" + rentedMovies.size() +
                '}';
    }
}
