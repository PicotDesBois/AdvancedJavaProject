package com.example.advancedjavaproject.Controller;

import com.example.advancedjavaproject.Controller.SignUp;
import com.example.advancedjavaproject.HelloApplication;
import com.example.advancedjavaproject.Model.Employees;
import com.example.advancedjavaproject.Model.Member;
import com.example.advancedjavaproject.Model.Password;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {

    private Stage lstage;
    private Scene scene;
    private Parent root;
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
    void OnClick(ActionEvent event) throws IOException {
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
                loadEmployeeHomePage(event,employees);
            }
            else // ici faut mettre la page une fois qu'un membre est co
                System.out.println("Membre co");

        }
        else
            txtError.setText("email or password error");

    }

    @FXML
    void clickSignUp(MouseEvent event) throws IOException {

        /// A mettre dans le programme qui appelle Sign up ///
        FXMLLoader fxmlLoaderSignUp = new FXMLLoader(HelloApplication.class.getResource("SignUp.fxml"));
        root =  fxmlLoaderSignUp.load();
        SignUp login = fxmlLoaderSignUp.getController();
        lstage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        scene =  new Scene(root);
        lstage.setScene(scene);
        lstage.show();
    }

    void loadEmployeeHomePage(Event event,Employees employees) throws IOException {

        // WARNING don't forget to put Controller Page in fxml Page //
        FXMLLoader fxmlLoaderEmployeeHomePage = new FXMLLoader(HelloApplication.class.getResource("EmployeeHomePage.fxml"));
        root =  fxmlLoaderEmployeeHomePage.load();
        EmployeeHomePage homePage = fxmlLoaderEmployeeHomePage.getController();
        homePage.setM_employee(employees);
        lstage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        scene =  new Scene(root);
        lstage.setScene(scene);
        lstage.show();

    }
}
