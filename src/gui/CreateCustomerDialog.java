package gui;

import application.models.Customer;
import gui.component.LabeledTextInput;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateCustomerDialog extends Stage {
    private Customer newCustomer;

    public CreateCustomerDialog() {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        VBox customerInputs = new VBox();
        HBox buttonBox = new HBox();
        LabeledTextInput nameInput = new LabeledTextInput("Navn");
        LabeledTextInput mobileInput = new LabeledTextInput("Mobilnummer");
        Button createButton = new Button("Opret kunde");
        Button cancelButton = new Button("Annuller");
        buttonBox.getChildren().addAll(createButton, cancelButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(5));
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        customerInputs.getChildren().addAll(nameInput, mobileInput, buttonBox);
        createButton.setOnAction(event -> {
            newCustomer = new Customer(nameInput.getInputValue(), mobileInput.getInputValue());
            this.close();
        });
        cancelButton.setOnAction(event -> this.close());
        Scene scene = new Scene(customerInputs);
        this.setScene(scene);
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }
}
