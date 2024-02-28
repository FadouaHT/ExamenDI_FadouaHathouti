package com.example.bibiliotecaeduardoprimo.models;

import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Atributos: List Libros[], List Prestamos[], List Usuarios[]

    private List<Libro> libros = new ArrayList<>();
    private List<Prestamo> prestamos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(List<Libro> libros, List<Prestamo> prestamos, List<Usuario> usuarios) {
        this.libros = libros;
        this.prestamos = prestamos;
        this.usuarios = usuarios;
    }

    //• Métodos : AltaLibro(Id_Libro, Titulo, Isbn), BajaLibro(Id_Libro)
    public void altaLibro(int idLibro, String Titulo, String isbn) {
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

    public void bajaLibro(int idLibro) {
        for (Libro libro : libros) {
            if (libro.getIdLibro() == idLibro) {
                libros.remove(libro);
                break;
            }
        }
    }

    //Métodos: Prestar(Id_libro, Dni_Usuario), Devolver(Id_libro, Dni_Usuario)

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
