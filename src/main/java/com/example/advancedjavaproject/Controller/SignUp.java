package com.example.advancedjavaproject.Controller;

import com.example.advancedjavaproject.HelloApplication;
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
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {

    @FXML
    private Label txtEmailError;

    @FXML
    private TextField txtName;

    @FXML
    private Label txtNameError;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label txtPasswordError;

    @FXML
    private TextField txtSurname;

    @FXML
    private Label txtSurnameError;

    @FXML
    private TextField txtemail;

    private Stage lstage;
    private Scene scene;
    private Parent root;

    @FXML
    void submit(ActionEvent event) throws IOException {
        boolean validate=false;
        if(txtName.getText().equals(""))
            txtNameError.setText("wrong name");
        else
        {
            txtNameError.setText("");

            if(txtSurname.getText().equals(""))
                txtSurnameError.setText("wrong surname");
            else
            {
                txtSurnameError.setText("");

                if(txtPassword.getText().equals(""))
                    txtPasswordError.setText("wrong password");
                else
                {
                    txtPasswordError.setText("");

                    if(txtemail.getText().equals(""))
                        txtEmailError.setText("wrong email");
                    else
                    {
                        txtEmailError.setText("");
                        Password password = new Password(txtemail.getText());
                        if(password.findEmail())
                            txtEmailError.setText("This email already exist");
                        else
                            validate=true;
                    }
                }

            }

        }

        if(validate==true)
        {
            Password password = new Password(txtemail.getText(),txtPassword.getText());
            Member member = new Member(txtName.getText(),txtSurname.getText(),password);
            member.saveDatabse();
            loadLogin(event);
        }
    }
    public void loadLogin(Event event) throws IOException {
        /// A mettre dans le programme qui appelle Login ///
        FXMLLoader fxmlLoaderLogin = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        root =  fxmlLoaderLogin.load();
        Login login = fxmlLoaderLogin.getController();
        lstage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        scene =  new Scene(root);
        lstage.setScene(scene);
        lstage.show();
    }
}


