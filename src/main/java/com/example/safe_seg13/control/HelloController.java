package com.example.safe_seg13.control;

import com.example.safe_seg13.HelloApplication;
import com.example.safe_seg13.model.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.*;


public class HelloController {

    private String currentPassword;

    @FXML
    private Button openBTN;

    @FXML
    private PasswordField pass1PF;

    @FXML
    private PasswordField pass2PF;

    @FXML
    private PasswordField pass3PF;

    @FXML
    private PasswordField pass4PF;

    @FXML
    private PasswordField pass5PF;

    @FXML
    private PasswordField pass6PF;

    @FXML
    private Button openBT;

    @FXML
    void openSafe(ActionEvent event) throws IOException {

        if(checkPassword()){
            HelloApplication.showWindow("safe.fxml");
        }

    }

    @FXML
    boolean checkPassword(){

        String password = pass1PF.getText() + pass2PF.getText() + pass3PF.getText() + pass4PF.getText() + pass5PF.getText() + pass6PF.getText();

        if(password.equals(Password.getInstance().getPassword())){
            Stage currentStage = (Stage) pass1PF.getScene().getWindow();
            currentStage.hide();
            return true;

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("");
            alert.setContentText("Incorrect password");
            alert.showAndWait();
            return false;
        }
    }

}