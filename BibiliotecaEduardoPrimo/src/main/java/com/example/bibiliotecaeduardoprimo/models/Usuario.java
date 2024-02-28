package com.example.bibiliotecaeduardoprimo.models;

import java.time.LocalDate;
/**
 * This class represents a User in the library system.
 */
public class Usuario {
//    Atributos: Dni_Usuario, FechaAltaSanción.


    private String dniUsuario;
    private LocalDate fechaAltaSancion;

    private boolean sancionado;
    /**
     * Default constructor
     */
    public Usuario() {
    }

    /**
     * Constructor with parameters
     * @param dniUsuario The user's DNI
     * @param fechaAltaSancion The date when the user was sanctioned
     * @param sancionado Flag to indicate if the user is sanctioned or not
     */
    public Usuario(String dniUsuario, LocalDate fechaAltaSancion, boolean sancionado) {
        this.dniUsuario = dniUsuario;
        this.fechaAltaSancion = fechaAltaSancion;
        this.sancionado = sancionado;

    }


    /**
     * Check if the user is sanctioned
     * @return true if the user is sanctioned, false otherwise
     */
    public boolean isSancionado() {
        return sancionado;
    }

    /**
     * Set the sanction status of the user
     * @param sancionado The sanction status to set
     */
    public void setSancionado(boolean sancionado) {
        this.sancionado = sancionado;
    }

    /**
     * Get the user's DNI
     * @return The user's DNI
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Set the user's DNI
     * @param dniUsuario The DNI to set
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Get the date when the user was sanctioned
     * @return The date when the user was sanctioned
     */
    public LocalDate getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    /**
     * Set the date when the user was sanctioned
     * @param fechaAltaSancion The date to set
     */
    public void setFechaAltaSancion(LocalDate fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }
}
