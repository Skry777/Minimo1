package edu.upc.dsa.models;


import java.util.Queue;

public class Laboratorio {
 // definimos los parametros del laboratiorio
    int IDlab;
    String nombrelab;
    Queue<Muestra> ColaMuestras;

    //creamos un constructor con el nombre del laboratorio y otro vacio

    public Laboratorio(String nombrelab) {

        this.nombrelab = nombrelab;
    }

    public Laboratorio(){
    }

    //getters y setters
    public int getIDlab() {
        return IDlab;
    }

    public void setIDlab(int IDlab) {
        this.IDlab = IDlab;
    }

    public String getNombrelab() {
        return nombrelab;
    }

    public void setNombrelab(String nombrelab) {
        this.nombrelab = nombrelab;
    }

    public Queue<Muestra> getColaMuestras() {
        return ColaMuestras;
    }

    public void setColaMuestras(Queue<Muestra> colaMuestras) {
        ColaMuestras = colaMuestras;
    }

    public void addMuestras(Muestra nueva){
        this.ColaMuestras.add(nueva);
    }

    public Muestra procesarMuestra() {
        return this.ColaMuestras.poll();
    }
}
