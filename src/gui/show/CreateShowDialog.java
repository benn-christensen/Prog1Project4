package gui.show;

import application.models.Show;
import gui.component.LabeledDateInput;
import gui.component.LabeledTextInput;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CreateShowDialog extends Stage {
    private Show newShow;

    public CreateShowDialog() {
        this.setTitle("Opret Forestilling");
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        VBox showInputs = new VBox();
        HBox buttonBox = new HBox();
        LabeledTextInput nameInput = new LabeledTextInput("Navn");
        LabeledDateInput premierInput = new LabeledDateInput("Premierdato");
        LabeledDateInput endInput = new LabeledDateInput("Slutdato");
        Label validationErrorLabel = new Label("");
        validationErrorLabel.setStyle("-fx-text-fill: red;");
        Button createButton = new Button("Opret Forestilling");
        Button cancelButton = new Button("Annuller");
        buttonBox.getChildren().addAll(createButton, cancelButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(5));
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        showInputs.getChildren().addAll(nameInput, premierInput, endInput, validationErrorLabel, buttonBox);
        createButton.setOnAction(event -> {
            if (nameInput.getInputValue().isEmpty()) {
                validationErrorLabel.setText("Indtast navnet på forestillingen.");
            } else if (premierInput.getInputValue() == null) {
                validationErrorLabel.setText("Vælg en premieredato.");
            } else if (endInput.getInputValue() == null) {
                validationErrorLabel.setText("Vælg en slutdato.");
            } else if (premierInput.getInputValue().isAfter(endInput.getInputValue())) {
                validationErrorLabel.setText("Slutdato kan ikke være før premieredatoen");
            } else {
                newShow = new Show(nameInput.getInputValue(), premierInput.getInputValue(), endInput.getInputValue());
                this.close();
            }
        });
        //Reset validation error label when new date is picked.
        premierInput.getDatePicker().setOnAction(event -> validationErrorLabel.setText(""));
        endInput.getDatePicker().setOnAction(event -> validationErrorLabel.setText(""));
        cancelButton.setOnAction(event -> this.close());
        Scene scene = new Scene(showInputs);
        this.setScene(scene);
    }

    public Show getNewShow() {
        return newShow;
    }
}
