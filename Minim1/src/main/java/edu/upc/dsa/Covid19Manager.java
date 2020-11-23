package edu.upc.dsa;

import edu.upc.dsa.models.LabNotFoundException;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;

public interface Covid19Manager {
    //definimos las funciones que vamos a usar en nuestra implementacion

    public String ProcesarMuestra(int idlab) throws LabNotFoundException;
    public static final int maxlabs= 20;
    public void clear();
    public int numeroPersonas();
    public int numeroLaboratorios();
    public void addLab(Laboratorio lab);
    public void addPersona(Persona persona);
    public void enviarMuestra(Muestra muestra) throws LabNotFoundException;
    public int numeroMuestras();
}
