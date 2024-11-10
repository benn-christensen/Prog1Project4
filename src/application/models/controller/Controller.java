package application.models.controller;

import application.models.*;
import javafx.collections.ObservableList;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public static Show createShow(String name, LocalDate premierDate, LocalDate endDate) {
        if (premierDate.isAfter(endDate)) {
            System.out.println("Premier datoen skal være før slutdatoen.");
            return null;
        }
        Show show = new Show(name, premierDate, endDate);
        Storage.addShow(show);
        return show;
    }

    public static Customer createCustomer(String name, String mobileNumber) {
        Customer customer = new Customer(name, mobileNumber);
        Storage.addCustomer(customer);
        return customer;
    }

    public static Seat createSeat(int rowNumber, int seatNumber, int price, SeatType type) {
        Seat seat = new Seat(rowNumber, seatNumber, price, type);
        Storage.addSeat(seat);
        return seat;
    }

    public static ArrayList<Customer> getCustomers() {
        return Storage.getCustomers();
    }

    public static ArrayList<Show> getShows() {
        return Storage.getShows();
    }
}
