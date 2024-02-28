package com.example.bibiliotecaeduardoprimo.models;

import java.time.LocalDate;
/**
 * This class represents a Loan in the library system.
 */
public class Prestamo {
    //Atributos: Id_libro, Dni_Usuario, Fecha_devolución
    private int idLibro;
    private String dniUsuario;
    private LocalDate fechaDevolucion;
    /**
     * Default constructor
     */
    public Prestamo() {
    }
    /**
     * Constructor with parameters
     * @param idLibro The id of the book being loaned
     * @param dniUsuario The DNI of the user who is loaning the book
     * @param fechaDevolucion The date when the book is to be returned
     */
    public Prestamo(int idLibro, String dniUsuario, LocalDate fechaDevolucion) {
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }


    /**
     * Get the id of the book being loaned
     * @return The id of the book being loaned
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Set the id of the book being loaned
     * @param idLibro The id to set
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Get the DNI of the user who is loaning the book
     * @return The DNI of the user who is loaning the book
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Set the DNI of the user who is loaning the book
     * @param dniUsuario The DNI to set
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Get the date when the book is to be returned
     * @return The date when the book is to be returned
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Set the date when the book is to be returned
     * @param fechaDevolucion The date to set
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
