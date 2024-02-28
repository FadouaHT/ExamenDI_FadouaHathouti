package com.example.bibiliotecaeduardoprimo.models;

import java.time.LocalDate;

public class Libro {
    //Enumerado Temática: Novela, Ensayo, Científico, Revista, Infantil
    public enum Tematica {
        NOVELA, ENSAYO, CIENTIFICO, REVISTA, INFANTIL
    }
    //Atributos: Id_Libro (Obligatorio/Único), Titulo (O), Isbn (Obligatorio/Único), Autor,
    //Temática, Fecha edición.

    private int idLibro;
    private String titulo;
    private String isbn;
    private String autor;
    private Tematica tematica;
    private LocalDate fechaEdicion;

    public Libro() {
    }



    public Libro(String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    public Libro(int idLibro, String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Tematica getTematica() {
        return tematica;
    }

    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
}
