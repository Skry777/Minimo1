package edu.upc.dsa.models;

public class Muestra {

  // definimos parametros de la muestra

    int IDmuestra;
    int IDclinico;
    int IDpersona;
    String fechaExtraccion; //formato yyyy/mm/dd
    int IDlab;

    // creamos el constructor de la muestra 
    
    public Muestra(int IDmuestra, int IDclinico, int IDpersona, String fechaExtraccion, int IDlab) {
        this.IDmuestra = IDmuestra;
        this.IDclinico = IDclinico;
        this.IDpersona = IDpersona;
        this.fechaExtraccion = fechaExtraccion;
        this.IDlab = IDlab;
    }

    //creamos getters y setters//

    public int getIDmuestra() {
        return IDmuestra;
    }

    public void setIDmuestra(int IDmuestra) {
        this.IDmuestra = IDmuestra;
    }

    public int getIDclinico() {
        return IDclinico;
    }

    public void setIDclinico(int IDclinico) {
        this.IDclinico = IDclinico;
    }

    public int getIDpersona() {
        return IDpersona;
    }

    public void setIDpersona(int IDpersona) {
        this.IDpersona = IDpersona;
    }

    public String getFechaExtraccion() {
        return fechaExtraccion;
    }

    public void setFechaExtraccion(String fechaExtraccion) {
        this.fechaExtraccion = fechaExtraccion;
    }

    public int getIDlab() {
        return IDlab;
    }

    public void setIDlab(int IDlab) {
        this.IDlab = IDlab;
    }


}
