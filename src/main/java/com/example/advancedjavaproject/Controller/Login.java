package com.example.advancedjavaproject.Controller;

import com.example.advancedjavaproject.Model.Employees;
import com.example.advancedjavaproject.Model.Member;
import com.example.advancedjavaproject.Model.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Login {

    @FXML
    private TextField txtEmail;

    @FXML
    private Label txtError;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label txtSignup;

    //  login page //
    @FXML
    void OnClick(ActionEvent event) {
        boolean login;

        Password password = new Password(txtEmail.getText(),txtPassword.getText());
        login=password.getDataBase();
        if(login)
        {
            Member member = new Member(password);
            login=member.getDatabase();
            if(!login)
            {
                Employees employees = new Employees(password);
                login=employees.getDatabase();
                // ici faut mettre la page une fois qu'un employee est co
            }
            else // ici faut mettre la page une fois qu'un membre est co
                System.out.println();

        }
        else
            txtError.setText("email or password error");

    }

    @FXML
    void clickSignUp(MouseEvent event) {
        System.out.println("Sign up !!!");
        // Ici il faut mettre la page d'inscription
    }

}
