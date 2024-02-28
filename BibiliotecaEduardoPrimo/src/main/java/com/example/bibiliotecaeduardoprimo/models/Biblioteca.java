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
        Libro libro = new Libro();
        libro.setIdLibro(idLibro);
        libro.setTitulo(Titulo);
        libro.setIsbn(isbn);
        libros.add(libro);
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
        for (Usuario usuario : usuarios) {
            if (usuario.getDniUsuario().equals(dniUsuario)) {
                if (usuario.isSancionado()) {
                    if(usuario.getFechaAltaSancion().isBefore(LocalDate.now().minusDays(30))){
                        usuario.setSancionado(false);
                        Prestamo prestamo = new Prestamo();
                        prestamo.setIdLibro(idLibro);
                        prestamo.setDniUsuario(dniUsuario);
                        prestamos.add(prestamo);
                    }else {
                        System.out.println("El usuario esta sancionado");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Sancionado");
                        alert.setHeaderText("El usuario esta sancionado");
                        alert.showAndWait();
                    }
                } else {
                    Prestamo prestamo = new Prestamo();
                    prestamo.setIdLibro(idLibro);
                    prestamo.setDniUsuario(dniUsuario);
                    prestamos.add(prestamo);
                }
                return;

            }
        }

    }

    public void devolver(int idLibro, String dniUsuario) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdLibro() == idLibro && prestamo.getDniUsuario().equals(dniUsuario)) {
                if (prestamo.getFechaDevolucion().isAfter(LocalDate.now())) {
                    for (Usuario usuario : usuarios) {
                        if (usuario.getDniUsuario().equals(dniUsuario)) {
                            usuario.setSancionado(true);
                            usuario.setFechaAltaSancion(LocalDate.now());
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
