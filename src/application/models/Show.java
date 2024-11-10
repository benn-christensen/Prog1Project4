package application.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

    public void addTicketOrder(TicketOrder ticketOrder) {
        ticketOrders.add(ticketOrder);
    }

    public boolean checkAvailability(int rowNumber, int seatNumber, LocalDate date) {
        for (TicketOrder ticketOrder : ticketOrders) {
            if (ticketOrder.hasBooked(rowNumber, seatNumber, date)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        DateTimeFormatter longDateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        return name + " (" + longDateFormat.format(premierDate) + " - " + longDateFormat.format(endDate) + ")";
    }
}
