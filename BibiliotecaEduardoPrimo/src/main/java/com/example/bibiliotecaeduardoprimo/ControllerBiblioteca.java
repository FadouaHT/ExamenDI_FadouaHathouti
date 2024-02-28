package com.example.bibiliotecaeduardoprimo;

import com.example.bibiliotecaeduardoprimo.models.Libro;

import com.example.bibiliotecaeduardoprimo.models.Biblioteca;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the library screen.
 */

public class ControllerBiblioteca {

    @FXML
    private ListView<Libro> listaLibros;

    public static Biblioteca biblioteca;

    private ObservableList<Libro> observableList;

    private Libro libroSeleccionado;
    /**
     * Initializes the controller.
     */
    public void initialize() {
        listaLibros.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> libroSeleccionado = newValue);
        biblioteca = new Biblioteca();
        generarListaLibros();
        observableList = listaLibros.getItems();
        observableList.addAll(biblioteca.getLibros());
    }
    /**
     * Generates a list of books.
     */
    public void generarListaLibros() {
        biblioteca.altaLibro(1, "Titulo", "1234567890123");
        biblioteca.altaLibro(2, "Titulo2", "1234567890124");
        biblioteca.altaLibro(3, "Titulo3", "1234567890125");

    }
    /**
     * Handles the action of the delete book button.
     * Deletes the selected book from the list.
     *
     * @param event the action event
     */
    @FXML
    void eliminarLibro(ActionEvent event) {
        if (libroSeleccionado != null) {
            biblioteca.bajaLibro(libroSeleccionado.getIdLibro());
            observableList.remove(libroSeleccionado);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Libro no seleccionado");
            alert.setHeaderText("No has seleccionado ningun libro");
            alert.showAndWait();
        }

    }

    @FXML
    void nuevoLibro(ActionEvent event) throws IOException {
        //ir a la otra vista
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/bibiliotecaeduardoprimo/libro.fxml"));
        Scene escenaVista = new Scene(root, 550, 300);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(escenaVista);
        stage.show();
    }

    @FXML
    void nuevoPrestamo(ActionEvent event) {

    }

}
