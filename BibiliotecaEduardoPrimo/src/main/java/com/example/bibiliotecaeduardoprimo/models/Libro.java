package com.example.bibiliotecaeduardoprimo.models;

import java.time.LocalDate;

/**
 * This class represents a Book in the library system.
 */
public class Libro {
    //Enumerado Temática: Novela, Ensayo, Científico, Revista, Infantil

    /**
     * Enum representing the thematic of the book.
     */
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

    /**
     * Default constructor
     */
    public Libro() {
    }


    /**
     * Constructor with parameters excluding idLibro
     *
     * @param titulo       The title of the book
     * @param isbn         The isbn of the book
     * @param autor        The author of the book
     * @param tematica     The thematic of the book
     * @param fechaEdicion The edition date of the book
     */
    public Libro(String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Constructor with all parameters
     *
     * @param idLibro      The id of the book
     * @param titulo       The title of the book
     * @param isbn         The isbn of the book
     * @param autor        The author of the book
     * @param tematica     The thematic of the book
     * @param fechaEdicion The edition date of the book
     */
    public Libro(int idLibro, String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }


    /**
     * Get the id of the book
     *
     * @return The id of the book
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Set the id of the book
     *
     * @param idLibro The id to set
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Get the title of the book
     *
     * @return The title of the book
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Set the title of the book
     *
     * @param titulo The title to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Get the isbn of the book
     *
     * @return The isbn of the book
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Set the isbn of the book
     *
     * @param isbn The isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Get the author of the book
     *
     * @return The author of the book
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Set the author of the book
     *
     * @param autor The author to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Get the thematic of the book
     *
     * @return The thematic of the book
     */
    public Tematica getTematica() {
        return tematica;
    }

    /**
     * Set the thematic of the book
     *
     * @param tematica The thematic to set
     */
    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    /**
     * Get the edition date of the book
     *
     * @return The edition date of the book
     */
    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Set the edition date of the book
     *
     * @param fechaEdicion The edition date to set
     */
    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    @Override
    public String toString() {
        return
                "ID: " + idLibro +
                        ", " + titulo +
                        ", isbn='" + isbn;
    }
}
