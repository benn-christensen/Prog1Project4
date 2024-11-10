package gui;

import application.models.Customer;
import application.models.controller.Controller;
import gui.component.AttributeDisplay;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CustomerPane extends GridPane {
    public CustomerPane() {
        this.setPadding(new Insets(5));
        ListView<Customer> customerListView = new ListView<>();
        customerListView.setMinWidth(300);
        customerListView.getItems().setAll(Controller.getCustomers());
        this.add(customerListView, 0, 0);
        VBox detailsBox = new VBox();
        detailsBox.setSpacing(5);
        detailsBox.setPadding(new Insets(0, 5, 10, 10));
        AttributeDisplay nameDisplay = new AttributeDisplay("Navn", "");
        AttributeDisplay mobileNumberDisplay = new AttributeDisplay("Mobilnummer", "");
        detailsBox.getChildren().addAll(nameDisplay, mobileNumberDisplay);
        this.add(detailsBox, 1, 0);

        customerListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            nameDisplay.setValue(newValue.getName());
            mobileNumberDisplay.setValue(newValue.getMobileNumber());
        });
    }
}
