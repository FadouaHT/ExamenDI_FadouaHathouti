package com.example.bibiliotecaeduardoprimo.models;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * This class represents a Library in the library system.
 * It contains lists of books, loans, and users.
 */
public class Biblioteca {
    // Atributos: List Libros[], List Prestamos[], List Usuarios[]

    private List<Libro> libros = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    /**
     * Default constructor
     */
    public Biblioteca() {
    }


    /**
     * Constructor with parameters
     * @param libros List of books
     * @param prestamos List of loans
     * @param usuarios List of users
     */
    public Biblioteca(List<Libro> libros, List<Prestamo> prestamos, List<Usuario> usuarios) {
        this.libros = libros;
        this.prestamos = prestamos;
        this.usuarios = usuarios;
    }
    /**
     * Method to add a book to the library
     * @param idLibro The id of the book
     * @param Titulo The title of the book
     * @param isbn The isbn of the book
     */
    //• Métodos : AltaLibro(Id_Libro, Titulo, Isbn), BajaLibro(Id_Libro)
    public void altaLibro(int idLibro, String Titulo, String isbn) {
        if(Titulo.isEmpty() || isbn.isEmpty()|| idLibro == 0){
            System.out.println("El titulo, el isbn o el id no pueden estar vacios");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Titulo o isbn vacios");
            alert.setHeaderText("El titulo o el isbn no pueden estar vacios");
            alert.showAndWait();
            return;
        }
        for (Libro libro : libros) {
            if (libro.getIdLibro() == idLibro || libro.getIsbn().equals(isbn)) {
//                System.out.println("El libro o el isbn ya existen");
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Libro o isbn ya existen");
//                alert.setHeaderText("El libro o el isbn ya existen");
//                alert.showAndWait();
                return;
            }
        }
        Libro newLibro = new Libro();
        newLibro.setIdLibro(idLibro);
        newLibro.setTitulo(Titulo);
        newLibro.setIsbn(isbn);
        libros.add(newLibro);

    }

    /**
     * Method to remove a book from the library
     * @param idLibro The id of the book
     */
    public void bajaLibro(int idLibro) {
        for (Libro libro : libros) {
            if (libro.getIdLibro() == idLibro) {
                libros.remove(libro);
                break;
            }
        }
    }

    //Métodos: Prestar(Id_libro, Dni_Usuario), Devolver(Id_libro, Dni_Usuario)
    /**
     * Method to loan a book to a user
     * @param idLibro The id of the book
     * @param dniUsuario The DNI of the user
     */
    public void prestar(int idLibro, String dniUsuario) {

        Usuario usuarioPrestamo = null;
        Libro libroPrestamo = null;

        // Buscar el usuario y el libro correspondientes
        for (Usuario usuario : usuarios) {
            if (usuario.getDniUsuario().equals(dniUsuario)) {
                usuarioPrestamo = usuario;
                break;
            }
        }
        for (Libro libro : libros) {
            if (libro.getIdLibro() == idLibro) {
                libroPrestamo = libro;
                break;
            }
        }

        // Verificar si el usuario y el libro existen y si el usuario no está sancionado
        if (usuarioPrestamo != null && libroPrestamo != null && !usuarioPrestamo.isSancionado()) {
            Prestamo prestamo = new Prestamo();
            prestamo.setFechaDevolucion(LocalDate.now().plusDays(14));
            prestamo.setIdLibro(idLibro);
            prestamo.setDniUsuario(dniUsuario);
            prestamos.add(prestamo);
        } else {
            System.out.println("El usuario no existe, el libro no existe o el usuario está sancionado");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error al prestar");
            alert.setHeaderText("El usuario no existe, el libro no existe o el usuario está sancionado");
            alert.showAndWait();
        }


    }
    /**
     * Method for a user to return a book
     * @param idLibro The id of the book
     * @param dniUsuario The DNI of the user
     */
    public void devolver(int idLibro, String dniUsuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro() == idLibro && prestamo.getDniUsuario().equals(dniUsuario)) {
                if (prestamo.getFechaDevolucion().isBefore(LocalDate.now())) {
                    for (Usuario usuario : usuarios) {
                        if (usuario.getDniUsuario().equals(dniUsuario)) {
                            usuario.setSancionado(true);
                            usuario.setFechaAltaSancion(LocalDate.now().plusDays(10));
                        }
                    }
                }
                prestamos.remove(prestamo);
                break;
            }
        }
    }


    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


}
