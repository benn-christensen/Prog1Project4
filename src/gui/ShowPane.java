package gui;

import application.models.Show;
import application.models.controller.Controller;
import gui.component.AttributeDisplay;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ShowPane extends GridPane {
    public ShowPane() {
        this.setPadding(new Insets(5));
        ListView<Show> showListView = new ListView<>();
        showListView.setMinWidth(300);
        showListView.getItems().setAll(Controller.getShows());
        this.add(showListView, 0, 0);
        VBox detailsBox = new VBox();
        detailsBox.setSpacing(5);
        detailsBox.setPadding(new Insets(0, 5, 10, 10));
        AttributeDisplay nameDisplay = new AttributeDisplay("Navn", "");
        AttributeDisplay premierDate = new AttributeDisplay("Premier dato", "");
        AttributeDisplay endDate = new AttributeDisplay("Slutdato", "");
        detailsBox.getChildren().addAll(nameDisplay, premierDate, endDate);
        this.add(detailsBox, 1, 0);

        showListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nameDisplay.setValue(newValue.getName());
                DateTimeFormatter longDateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
                premierDate.setValue(newValue.getPremierDate().format(longDateFormat));
                endDate.setValue(newValue.getEndDate().format(longDateFormat));
            }
        });

        Button createshowButton = new Button("Opret Forestilling");
        this.add(createshowButton, 1, 2);
        GridPane.setHalignment(createshowButton, HPos.RIGHT);

        createshowButton.setOnAction(event -> {
            CreateShowDialog createShowDialog = new CreateShowDialog();
            createShowDialog.showAndWait();
            Show newShow = createShowDialog.getNewShow();
            if (newShow != null) {
                Controller.createShow(newShow.getName(), newShow.getPremierDate(), newShow.getEndDate());
                showListView.getItems().setAll(Controller.getShows());
            }
        });


    }
}
