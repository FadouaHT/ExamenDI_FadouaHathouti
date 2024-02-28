package com.example.bibiliotecaeduardoprimo;


import com.example.bibiliotecaeduardoprimo.models.Libro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Controller for the book screen.
 */
public class ControllerLibro {

    @FXML
    private Button btnGuardar;

    @FXML
    private ChoiceBox<String> cbtematica;

    @FXML
    private DatePicker dpFechaEdicion;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtISBN;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTitulo;

    /**
     * Initializes the controller.
     */
    public void initialize() {
        cbtematica.getItems().addAll("NOVELA", "ENSAYO", "CIENTIFICO", "REVISTA", "INFANTIL");
    }
    /**
     * Handles the action of the save book button.
     * Saves the book and returns to the library screen.
     *
     * @param event the action event
     * @throws IOException if an I/O error occurs during loading
     */
    @FXML
    void guardarLibro(ActionEvent event) throws IOException {
        if(txtId.getText().isEmpty() || txtTitulo.getText().isEmpty()|| txtISBN.getText().isEmpty() ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos vacios");
            alert.setHeaderText("El id, el titulo o el isbn no pueden estar vacios");
            alert.showAndWait();
        }else {
            Libro libro = new Libro();
            libro.setIdLibro(Integer.parseInt(txtId.getText()));
            libro.setTitulo(txtTitulo.getText());
            libro.setIsbn(txtISBN.getText());
            libro.setAutor(txtAutor.getText());
            libro.setTematica(Libro.Tematica.valueOf(cbtematica.getValue()));
            libro.setFechaEdicion(dpFechaEdicion.getValue());
            ControllerBiblioteca.biblioteca.altaLibro(libro.getIdLibro(), libro.getTitulo(), libro.getIsbn());
            btnGuardar.getScene().getWindow().hide();

            Parent root = FXMLLoader.load(getClass().getResource("/com/example/bibiliotecaeduardoprimo/biblioteca.fxml"));
            Scene escenaVista = new Scene(root, 550, 300);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(escenaVista);
            stage.show();


        }
    }

}
