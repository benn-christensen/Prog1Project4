package gui;

import application.models.Customer;
import application.models.controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class CustomerPane extends GridPane {
    public CustomerPane() {
        this.setVgap(10);
        this.setHgap(10);
        this.add(new Label("Kunder:"), 0, 0);
        ListView<Customer> customerListView = new ListView<>();
        customerListView.getItems().setAll(Controller.getCustomers());
        this.add(customerListView, 0, 1);
    }
}
