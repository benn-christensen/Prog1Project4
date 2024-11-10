package application.models;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String mobileNumber;
    private ArrayList<TicketOrder> orders = new ArrayList<>();

    public Customer(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void addOrder(TicketOrder ticketOrder) {
        orders.add(ticketOrder);
    }

    @Override
    public String toString() {
        return "Kunde{" + "navn = " + name + ", mobilnummer = " + mobileNumber + '}';
    }
}
