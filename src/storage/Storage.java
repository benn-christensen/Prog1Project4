package storage;

import application.models.Customer;
import application.models.Seat;
import application.models.Show;
import application.models.TicketOrder;

import java.util.ArrayList;

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
}
