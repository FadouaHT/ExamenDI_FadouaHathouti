module com.example.bibiliotecaeduardoprimo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bibiliotecaeduardoprimo to javafx.fxml;
    exports com.example.bibiliotecaeduardoprimo;
}