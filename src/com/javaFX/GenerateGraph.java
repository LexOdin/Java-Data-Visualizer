package com.javaFX;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.sound.sampled.Line;

public class GenerateGraph extends Application {

    ComboBox comboBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GraphPaneManager gpManager = new GraphPaneManager(this);

        StackPane root = MainUIInitialization(primaryStage, gpManager);

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private StackPane MainUIInitialization(Stage primaryStage, GraphPaneManager gpManager) {
        primaryStage.setTitle("Graph Generator");
        Button btn = new Button();
        btn.setText("Generate Graph");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            Stage secondaryStage = new Stage();

            @Override
            public void handle(ActionEvent event) {
                gpManager.GenerateGraph(event);
            }
        });

        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Line Chart",
                        "Pie Chart",
                        "Option 3"
                );
        comboBox = new ComboBox(options);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        //grid.add(new Label("To: "), 0, 0);
        //grid.add(new Label("Priority: "), 2, 0);
        grid.add(comboBox, 0, 0);
        grid.add(btn, 0, 1);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                gpManager.CloseStage();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(grid);

        return root;
    }

    public ComboBox GetComboBox() {
        return comboBox;
    }
}

class GraphPaneManager {
    Stage secondaryStage;
    GenerateGraph mainSystem;
    public GraphPaneManager(GenerateGraph input) {
        secondaryStage = new Stage();
        mainSystem = input;
    }

    public void GenerateGraph(ActionEvent event) {

        switch((String)mainSystem.comboBox.getValue()) {
            case "Line Chart":
                LineChartStage LStage = new LineChartStage();
                LStage.start(secondaryStage);
                break;
            case "Pie Chart":
                PieChartStage PStage = new PieChartStage();
                PStage.start(secondaryStage);
            default:
                break;
        }

    }

    public void CloseStage() {
        if(secondaryStage != null) {
            secondaryStage.close();
        }
    }
}