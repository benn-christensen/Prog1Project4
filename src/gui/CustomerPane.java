package gui;

import application.models.Customer;
import application.models.controller.Controller;
import gui.component.AttributeDisplay;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class CustomerPane extends GridPane {
    public CustomerPane() {
        this.setGridLinesVisible(true);
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
            if (newValue != null) {
                nameDisplay.setValue(newValue.getName());
                mobileNumberDisplay.setValue(newValue.getMobileNumber());
            }
        });
        Button createCustomerButton = new Button("Opret kunde");
        this.add(createCustomerButton, 1, 2);
        GridPane.setHalignment(createCustomerButton, HPos.RIGHT);

        createCustomerButton.setOnAction(event -> {
            CreateCustomerDialog createCustomerDialog = new CreateCustomerDialog();
            createCustomerDialog.showAndWait();
            Customer newCustomer = createCustomerDialog.getNewCustomer();
            if (createCustomerDialog.getNewCustomer() != null) {
                Controller.createCustomer(newCustomer.getName(), newCustomer.getMobileNumber());
                customerListView.getItems().setAll(Controller.getCustomers());
            }
        });
    }
}
