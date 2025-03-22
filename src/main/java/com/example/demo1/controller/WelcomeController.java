package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomeController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnExit;

    @FXML
    private void handleLogin() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/view/LoginForm.fxml"));
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleRegister() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/view/Signup.fxml"));
        Stage stage = (Stage) btnRegister.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }
}