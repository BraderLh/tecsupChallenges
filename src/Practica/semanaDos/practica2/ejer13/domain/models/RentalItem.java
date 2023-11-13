package Practica.semanaDos.practica2.ejer13.domain.models;

import java.util.PrimitiveIterator;

public class RentalItem
{
    protected final int idItem;
    protected static int rentalItemCounter;
    protected String itemName;
    protected boolean available;

    public RentalItem(String itemName) {
        this.itemName = itemName;
        this.available = true;
        idItem = ++RentalItem.rentalItemCounter;
    }

    public int getIdItem() {
        return idItem;
    }

    public static int getRentalItemCounter() {
        return rentalItemCounter;
    }

    public static void setRentalItemCounter(int rentalItemCounter) {
        RentalItem.rentalItemCounter = rentalItemCounter;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String showDetails() {
        String msmAvailable = available ? "is available" : "not available";
        return "RentalItem{" +
                "idItem=" + idItem +
                ", itemName='" + itemName + '\'' +
                ", available=" + available +
                '}';
    }
}
