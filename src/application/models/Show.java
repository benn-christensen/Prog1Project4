package application.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Show {
    private String name;
    private LocalDate premierDate;
    private LocalDate endDate;
    private ArrayList<TicketOrder> ticketOrders = new ArrayList<>();

    public Show(String name, LocalDate premierDate, LocalDate endDate) {
        this.name = name;
        this.premierDate = premierDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getPremierDate() {
        return premierDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
