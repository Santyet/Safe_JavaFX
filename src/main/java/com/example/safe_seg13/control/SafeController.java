package com.example.safe_seg13.control;

import com.example.safe_seg13.HelloApplication;
import com.example.safe_seg13.model.Content;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SafeController implements Initializable {

    @FXML
    private Button changePasswordBTN;

    @FXML
    private Button closeBTN;

    @FXML
    private TextArea insideSafeTA;

    @FXML
    void showContent(){
        insideSafeTA.setText(Content.getInstance().getContent());
    }


    @FXML
    void ChangePassword(ActionEvent event) throws IOException {

        HelloApplication.showWindow("change-password.fxml");
        Stage currentStage = (Stage) insideSafeTA.getScene().getWindow();
        currentStage.hide();
    }

    @FXML
    void closeSafe(ActionEvent event) throws IOException {

        Content.getInstance().setContent(insideSafeTA.getText());
        HelloApplication.showWindow("hello-view.fxml");
        Stage currentStage = (Stage) insideSafeTA.getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        insideSafeTA.setText(Content.getInstance().getContent());
    }
}
