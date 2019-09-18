package com.javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GenerateGraph extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Graph Generator");
        Button btn = new Button();
        btn.setText("Generate Graph");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            Stage secondaryStage = new Stage();

            @Override
            public void handle(ActionEvent event) {
                JavaFXTest test = new JavaFXTest();

                test.start(secondaryStage);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}