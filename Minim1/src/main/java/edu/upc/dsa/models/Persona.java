package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;

public class Persona {

    // definimos parametros de la persona

    String nombre;
    String apellidos;
    int ID;
    int edad;
    String nivelSalud; //A,B,C,D
    List<Muestra> listamuestras; // cada persona tiene que tener una lista de muestras

    // creamos el constructor de la persona
    public Persona(String nombre, String apellidos, int ID, int edad, String nivelSalud) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ID = ID;
        this.edad = edad;
        this.nivelSalud = nivelSalud;
        this.listamuestras = new LinkedList<Muestra>();
    }

    //getters y setters
    public List<Muestra> getListamuestras() {
        return listamuestras;
    }

    public void setListamuestras(List<Muestra> listamuestras) {
        this.listamuestras = listamuestras;
    }

    public void addMuestra(Muestra muestra){
        this.listamuestras.add(muestra);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNivelSalud() {
        return nivelSalud;
    }

    public void setNivelSalud(String nivelSalud) {
        this.nivelSalud = nivelSalud;
    }


    // to string
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ID=" + ID +
                ", edad=" + edad +
                ", nivelSalud='" + nivelSalud + '\'' +
                ", listamuestras=" + listamuestras +
                '}';
    }
}
