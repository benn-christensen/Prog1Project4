package gui;

import application.models.Show;
import application.models.controller.Controller;
import gui.component.AttributeDisplay;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;

public class ShowPane extends GridPane {
    public ShowPane() {
        this.setPadding(new Insets(5));
        ListView<Show> customerListView = new ListView<>();
        customerListView.setMinWidth(300);
        customerListView.getItems().setAll(Controller.getShows());
        this.add(customerListView, 0, 0);
        VBox detailsBox = new VBox();
        detailsBox.setSpacing(5);
        detailsBox.setPadding(new Insets(0, 5, 10, 10));
        AttributeDisplay nameDisplay = new AttributeDisplay("Navn", "");
        AttributeDisplay premierDate = new AttributeDisplay("Premier dato", "");
        AttributeDisplay endDate = new AttributeDisplay("Slutdato", "");
        detailsBox.getChildren().addAll(nameDisplay, premierDate, endDate);
        this.add(detailsBox, 1, 0);

        customerListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            nameDisplay.setValue(newValue.getName());
            premierDate.setValue(newValue.getPremierDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            endDate.setValue(newValue.getEndDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        });

    }
}
