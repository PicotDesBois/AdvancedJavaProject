module com.example.advancedjavaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advancedjavaproject to javafx.fxml;
    exports com.example.advancedjavaproject;
}