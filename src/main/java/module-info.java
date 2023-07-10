module com.example.advancedjavaproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.advancedjavaproject to javafx.fxml;
    exports com.example.advancedjavaproject;
    exports com.example.advancedjavaproject.View;
    opens com.example.advancedjavaproject.View to javafx.fxml;
}