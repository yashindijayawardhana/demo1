package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnLogin;

    @FXML
    private void handleSignUp() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/view/Signup.fxml"));
        Stage stage = (Stage) btnSignUp.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void handleLogin() throws IOException {
        // Add your login logic here
        // For now, just navigate back to the Welcome page
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo1/view/Welcome.fxml"));
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
    }
}