/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author alumnodaw
 */
public class Usuario implements Serializable {
    private String nombre;
    private String contra;
    private int edad;
    private String equipo;
    private String ruta_foto;

    public Usuario(String nombre,String contra,String equipo,int edad, String ruta_foto) {
        this.nombre = nombre;
        this.contra = contra;
        this.edad = edad;
        this.equipo = equipo;
        this.ruta_foto = ruta_foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getRuta_foto() {
        return ruta_foto;
    }

    public void setRuta_foto(String ruta_foto) {
        this.ruta_foto = ruta_foto;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre +", contra=" + contra + ", edad=" + edad + ", equipo=" + equipo + ", ruta_foto=" + ruta_foto + '}';
    }
    
    
    
    
}
