package Practica.semanaDos.practica2.ejer13.app;

import Practica.semanaDos.practica2.ejer13.domain.core.Menu;
import Practica.semanaDos.practica2.ejer13.domain.core.MovieRentalSystem;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean flag;
        int option;
        MovieRentalSystem movieRentalSystem = new MovieRentalSystem("My Cornflix");
        do {
            System.out.println(menu.menuTitle(movieRentalSystem.getName()) + menu.optionsMenuTxt());
            System.out.println("Insert your option: ");
            option = scanner.nextInt();
            flag = menu.menuOptions(option, movieRentalSystem);
        }while (flag);
    }
}
