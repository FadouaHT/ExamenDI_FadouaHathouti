package com.example.bibiliotecaeduardoprimo.models;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    //Atributos únicos no repetidos, Atributos únicos repetidos
    @Test
    void altaLibroNoRepetidos() {
        // Casos de test: Atributos únicos no repetidos, Atributos únicos repetidos
        // Caso 1: Atributos únicos no repetidos
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "Titulo", "1234567890123");
        assertEquals(1, biblioteca.getLibros().size());
    }

    @Test
    void altaLibroRepetidos() {
        // Caso 2: Atributos únicos repetidos
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.altaLibro(1, "Titulo", "1234567890123");
        biblioteca.altaLibro(1, "Titulo", "1234567890123");
        assertEquals(1, biblioteca.getLibros().size());
    }


    @Test
    void prestarNoexistencia() {
        // Casos de test: Libro no existe, Usuario no existe, Libro existe, Usuario existe.
        // Caso 1: Libro y usuario no existe
        String dniUsuario = "12345678A";
        int idLibro = 1;
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.prestar(idLibro, dniUsuario);
        assertEquals(0, biblioteca.getPrestamos().size());
    }

    @Test
    void prestarExistencia() {
        Biblioteca biblioteca = new Biblioteca();
        // Caso 2: Usuario y libro existe
        Usuario usuario = new Usuario("12345678A", null, false);
        Libro libro = new Libro("Titulo", "1234567890123", "Autor", Libro.Tematica.NOVELA, LocalDate.of(2021, 1, 1));
        biblioteca.getUsuarios().add(usuario);
        biblioteca.getLibros().add(libro);
        biblioteca.prestar(libro.getIdLibro(), usuario.getDniUsuario());
        assertEquals(1, biblioteca.getPrestamos().size());
    }


   // Devolución en fecha
    @Test
    void devolverEnFecha() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("12345678A", null, false);
        Libro libro = new Libro("Titulo", "1234567890123", "Autor", Libro.Tematica.NOVELA, LocalDate.of(2021, 1, 1));

        biblioteca.getUsuarios().add(usuario);
        biblioteca.getLibros().add(libro);
        biblioteca.prestar(libro.getIdLibro(), usuario.getDniUsuario());
        System.out.println("Numero de prestamos antes de la devolucion "+biblioteca.getPrestamos().size());
        biblioteca.devolver(libro.getIdLibro(), usuario.getDniUsuario());
        assertEquals(0, biblioteca.getPrestamos().size());
        assertFalse(usuario.isSancionado());

    }
    // Devolución fuera de fecha
    @Test
    void devolverFueraFecha() {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario = new Usuario("12345678A", null, false);
        Libro libro = new Libro("Titulo", "1234567890123", "Autor", Libro.Tematica.NOVELA, LocalDate.of(2022, 1, 1));
        biblioteca.getUsuarios().add(usuario);
        biblioteca.getLibros().add(libro);
        biblioteca.prestar(libro.getIdLibro(), usuario.getDniUsuario());
        biblioteca.getPrestamos().get(0).setFechaDevolucion(LocalDate.now().minusDays(1));
        biblioteca.devolver(libro.getIdLibro(), usuario.getDniUsuario());
        assertEquals(0, biblioteca.getPrestamos().size());
        assertTrue(usuario.isSancionado());

    }
}