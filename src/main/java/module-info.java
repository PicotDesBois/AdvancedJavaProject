module com.example.advancedjavaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.advancedjavaproject to javafx.fxml;
    exports com.example.advancedjavaproject;
    exports com.example.advancedjavaproject.Controller;
    opens com.example.advancedjavaproject.Controller to javafx.fxml;
}