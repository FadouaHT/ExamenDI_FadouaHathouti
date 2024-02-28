package com.example.bibiliotecaeduardoprimo.models;

import java.time.LocalDate;

public class Usuario {
//    Atributos: Dni_Usuario, FechaAltaSanción.


    private String dniUsuario;
    private LocalDate fechaAltaSancion;

    private boolean sancionado;

    public Usuario() {
    }

    public Usuario(String dniUsuario, LocalDate fechaAltaSancion) {
        this.dniUsuario = dniUsuario;
        this.fechaAltaSancion = fechaAltaSancion;

    }

    public boolean isSancionado() {
        return sancionado;
    }

    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public LocalDate getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    public void setFechaAltaSancion(LocalDate fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }
}
