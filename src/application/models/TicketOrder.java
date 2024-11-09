package application.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class TicketOrder {
    private LocalDate date;
    private Show show;
    private Customer customer;
    private ArrayList<Seat> seats = new ArrayList<>();

    /**
     * This constructor is private and is only used by the createTicketOrder method
     */
    private TicketOrder(LocalDate date, Show show, Customer customer, ArrayList<Seat> seats) {
        this.date = date;
        this.show = show;
        this.customer = customer;
        this.seats = seats;
    }

    /**
     * creates a new TicketOrder
     *
     * @param @date the date of the show.
     * @param show the show for which the tickets are for
     * @param customer the customer who ordered the tickets
     * @param seats the seats for the show
     * @return the new TicketOrder
     */
    public static TicketOrder createTicketOrder(LocalDate date, Show show, Customer customer, ArrayList<Seat> seats) {
        if (show == null || customer == null || seats == null) {
            System.out.println("Ugyldig input");
            return null;
        }
        if (date == null || date.isBefore(show.getPremierDate()) || date.isAfter(show.getEndDate())) {
            System.out.println("Ugyldig dato");
            return null;
        }
        TicketOrder ticketOrder = new TicketOrder(date, show, customer, seats);
        //Sets the associations between the objects
        customer.addOrder(ticketOrder);
        show.addTicketOrder(ticketOrder);
        return ticketOrder;
    }

}
