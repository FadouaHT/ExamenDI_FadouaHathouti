package com.example.bibiliotecaeduardoprimo.models;

import java.time.LocalDate;

public class Prestamo {
    //Atributos: Id_libro, Dni_Usuario, Fecha_devolución
    private int idLibro;
    private String dniUsuario;
    private LocalDate fechaDevolucion;

    public Prestamo() {
    }
    public Prestamo(int idLibro, String dniUsuario, LocalDate fechaDevolucion) {
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
