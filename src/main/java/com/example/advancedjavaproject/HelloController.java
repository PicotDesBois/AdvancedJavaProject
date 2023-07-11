package com.example.advancedjavaproject;

import com.example.advancedjavaproject.Controller.Payment;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    private Stage lstage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void onHelloButtonClick(Event event) throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");

        /// A mettre dans le programme qui appelle payment ///
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Payment.fxml"));
        root =  fxmlLoader.load();
        Payment payment = fxmlLoader.getController();
        lstage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        scene =  new Scene(root);
        lstage.setScene(scene);
        lstage.show();

    }
}