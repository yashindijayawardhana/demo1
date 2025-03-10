package com.example.demo1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class GenerateReportsController {

    @FXML
    private ComboBox<String> cmbReportType;

    @FXML
    private TextArea txtReportPreview;

    @FXML
    private Button btnGenerateReport, btnExportExcel, btnBack;

    @FXML
    public void initialize() {
        ObservableList<String> reportTypes = FXCollections.observableArrayList(
                "Student Report", "Course Report", "Enrollment Report", "Academic Performance Report"
        );
        cmbReportType.setItems(reportTypes);
    }

    @FXML
    private void handleGenerateReport(ActionEvent event) {
        String selectedReport = cmbReportType.getValue();
        if (selectedReport == null) {
            showAlert("Validation Error", "Please select a report type.", Alert.AlertType.ERROR);
            return;
        }

        txtReportPreview.setText("Generating " + selectedReport + "...\nReport Data: [Sample Data]\n\nCompleted.");
    }

    @FXML
    private void handleExportExcel(ActionEvent event) {
        if (txtReportPreview.getText().isEmpty()) {
            showAlert("Export Error", "Please generate a report first.", Alert.AlertType.ERROR);
            return;
        }

        showAlert("Export Success", "Report exported successfully as Excel.", Alert.AlertType.INFORMATION);
    }

    @FXML
    private void handleBack(ActionEvent event) {
        navigateTo("/com/example/demo1/view/MainDashboard.fxml", event);
    }

    private void navigateTo(String fxmlFile, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Navigation Error", "Unable to load the requested page.", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
