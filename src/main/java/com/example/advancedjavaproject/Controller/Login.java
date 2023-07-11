package com.example.advancedjavaproject.Controller;

import com.example.advancedjavaproject.Model.Member;
import com.example.advancedjavaproject.Model.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void OnClick(ActionEvent event) {
        boolean login;

        Password password = new Password(txtEmail.getText(),txtPassword.getText());
        login=password.getDataBase();
        if(login)
        {
            System.out.println("Mdp correct");
            Member member = new Member(password);
            login=member.getDatabase();
        }
        else
            System.out.println("Erreur mdp");

    }

}
