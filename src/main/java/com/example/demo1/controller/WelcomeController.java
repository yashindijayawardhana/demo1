package com.example.demo1.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnExit;

    @FXML
    void onLogin(ActionEvent event) {
        loadPage("/com/example/demo1/view/Login.fxml");
    }

    @FXML
    void onRegister(ActionEvent event) {
        loadPage("/com/example/demo1/view/Register.fxml");
    }

    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);
    }

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
