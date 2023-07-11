package com.example.advancedjavaproject.Controller;

import com.example.advancedjavaproject.Model.Bank;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalDate;

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

        Bank card = new Bank(txtNumber.getText(),txtName.getText(),txtDate.getValue(),txtPass.getText());

        card.setDatabase();
        card.getDataBase();
    }
}
