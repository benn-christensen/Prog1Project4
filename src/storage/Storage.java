package storage;

import application.models.Customer;
import application.models.Seat;
import application.models.Show;

import java.util.ArrayList;
import java.util.Collections;

public class Storage {
    private static ArrayList<Show> shows = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Seat> seats = new ArrayList<>();

    public static void addShow(Show show) {
        shows.add(show);
    }

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void addSeat(Seat seat) {
        seats.add(seat);
    }

    public static void sortSeats() {
        Collections.sort(seats, (Seat seat1, Seat seat2) -> {
            if (seat1.getRowNumber() == seat2.getRowNumber()) {
                return seat1.getSeatNumber() - seat2.getSeatNumber();
            }
            return seat1.getRowNumber() - seat2.getRowNumber();
        });
    }

    public static ArrayList<Show> getShows() {
        return new ArrayList<>(shows);
    }

    public static ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }

    public static ArrayList<Seat> getSeats() {
        return new ArrayList<>(seats);
    }
}
