package com.example.demo1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ProfileController {

    @FXML
    private ImageView profileImageView;

    @FXML
    private Button btnUpload;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtContact;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnBack;

    @FXML
    void onUploadImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Profile Picture");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));

        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            profileImageView.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    void onEditProfile() {
        txtFullName.setEditable(true);
        txtEmail.setEditable(true);
        txtContact.setEditable(true);
    }

    @FXML
    void onSaveProfile() {
        txtFullName.setEditable(false);
        txtEmail.setEditable(false);
        txtContact.setEditable(false);
        System.out.println("Profile Saved: " + txtFullName.getText() + ", " + txtEmail.getText() + ", " + txtContact.getText());
    }

    @FXML
    void onBack() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo1/view/Welcome.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
