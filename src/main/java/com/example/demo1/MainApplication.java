package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Ensure correct path to FXML file
            URL fxmlLocation = getClass().getResource("/com/example/View/AdminDashboard.fxml");


            if (fxmlLocation == null) {
                System.err.println("ERROR: FXML file not found! Check your file path.");
                return;
            }

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Pane root = fxmlLoader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Welcome Page");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
