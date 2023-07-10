package com.example.advancedjavaproject.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Payment {
    @FXML
    private DatePicker txtDate;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNumber;

    @FXML
    private PasswordField txtPass;

    @FXML
    void OnClick(ActionEvent event) {
        System.out.println(txtDate.getConverter());
        System.out.println(txtName.getText());
        System.out.println(txtNumber.getText());
        System.out.println(txtPass.getText());
    }
}
