package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage)  {
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().add(new Tab("Kunder", new CustomerPane()));
        tabPane.getTabs().add(new Tab("Forestillinger", new ShowPane()));
        Scene scene = new Scene(tabPane);
        stage.setScene(scene);
        stage.show();
    }
}
