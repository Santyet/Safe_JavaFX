package com.example.safe_seg13.control;

import com.example.safe_seg13.HelloApplication;
import com.example.safe_seg13.model.Content;
import com.example.safe_seg13.model.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class PasswordChangeController {

    @FXML
    private Button changePasswordBTN;

    @FXML
    private Button closeBTN;

    @FXML
    private PasswordField pass1PF;

    @FXML
    private PasswordField pass1PF1;

    @FXML
    private PasswordField pass2PF;

    @FXML
    private PasswordField pass2PF1;

    @FXML
    private PasswordField pass3PF;

    @FXML
    private PasswordField pass3PF1;

    @FXML
    private PasswordField pass4PF;

    @FXML
    private PasswordField pass4PF1;

    @FXML
    private PasswordField pass5PF;

    @FXML
    private PasswordField pass5PF1;

    @FXML
    private PasswordField pass6PF;

    @FXML
    private PasswordField pass6PF1;

    @FXML
    void ChangePassword(ActionEvent event) throws IOException {

        String actualPassword = pass1PF.getText() + pass2PF.getText() + pass3PF.getText() + pass4PF.getText() + pass5PF.getText() + pass6PF.getText();
        String newPassword = pass1PF1.getText() + pass2PF1.getText() + pass3PF1.getText() + pass4PF1.getText() + pass5PF1.getText() + pass6PF1.getText();
        if(actualPassword.equals(Password.getInstance().getPassword())){
            Password.getInstance().setPassword(newPassword);
            Stage currentStage = (Stage) pass1PF.getScene().getWindow();
            HelloApplication.showWindow("hello-view.fxml");
            currentStage.hide();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.setContentText("Incorrect password");
            alert.showAndWait();
        }
    }

    @FXML
    void closeSafe(ActionEvent event) throws IOException {

        HelloApplication.showWindow("hello-view.fxml");
        Stage currentStage = (Stage) pass1PF.getScene().getWindow();
        currentStage.close();
    }

}
