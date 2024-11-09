package application.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class TicketOrder {
    private LocalDate date;
    private Show show;
    private Customer customer;
    private ArrayList<Seat> seats = new ArrayList<>();
}
