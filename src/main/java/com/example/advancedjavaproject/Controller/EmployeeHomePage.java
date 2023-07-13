package com.example.advancedjavaproject.Controller;

import com.example.advancedjavaproject.HelloApplication;
import com.example.advancedjavaproject.Model.Employees;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class EmployeeHomePage {

    private Stage lstage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label txtTitle;
    Employees m_employee;

    public void setM_employee(Employees employee) {
        this.m_employee = employee;
        txtTitle.setText("Hello "+m_employee.getM_EmName());
    }

    @FXML
    void addMovie(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoaderAddMovie = new FXMLLoader(HelloApplication.class.getResource("AddMovie.fxml"));
        root =  fxmlLoaderAddMovie.load();
        EmployeeHomePage homePage = fxmlLoaderAddMovie.getController();
        lstage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        scene =  new Scene(root);
        lstage.setScene(scene);
        lstage.show();
    }

    @FXML
    void addMovieShow(ActionEvent event) {

    }

    @FXML
    void removeMovie(ActionEvent event) {

    }

    @FXML
    void removeMovieShow(ActionEvent event) {

    }
}
