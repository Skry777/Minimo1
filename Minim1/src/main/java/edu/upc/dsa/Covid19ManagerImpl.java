package edu.upc.dsa;

import edu.upc.dsa.models.LabNotFoundException;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class Covid19ManagerImpl implements Covid19Manager{

    static final Logger log = Logger.getLogger(Covid19ManagerImpl.class.getName());
    private static Covid19Manager instance;
    private int numeroLabs;
    private int numeroMuestras;
    private Laboratorio laboratorios[];
    private HashMap<Integer, Persona> diccionarioPersonas;


    private Covid19ManagerImpl(){
        this.diccionarioPersonas = new HashMap<Integer, Persona>();
        numeroLabs = 0;
        this.laboratorios = new Laboratorio[maxlabs];
    }
    public static Covid19Manager getInstance(){ // comprobamos que solo hay 1 instancia singleton, si no hay la creamos
        if (instance == null) {
            instance = new Covid19ManagerImpl();
        }

        return instance;
    }


//funcion para conseguir la id del laboratorio
    public Laboratorio getLaboratoriobyID(int idlab) throws LabNotFoundException {
        Laboratorio lab = new Laboratorio();
        for (int j= 0; j< numeroLabs; j++)
        {
            if(laboratorios[j].getIDlab() == idlab){
                lab = laboratorios[j];
                break;
            }

        }
        if(lab==null)
        {
            throw new LabNotFoundException();
        }
        else{
            return lab;
        }

    }
    @Override
    public void addPersona(Persona persona) {
        log.info("Antes de añadir persona:  "+diccionarioPersonas);
        this.diccionarioPersonas.put(persona.getID(), persona);
        log.info("Despues de añadir persona:    "+diccionarioPersonas);
    }



    @Override
    public void enviarMuestra(Muestra nueva) throws LabNotFoundException {
        log.info("Entramos para enviar una muestra al laboratorio");
        Laboratorio laboratorioProcesar = getLaboratoriobyID(nueva.getIDlab());
        laboratorioProcesar.addMuestras(nueva);
        numeroMuestras++;
        log.info("hemos enviado la muesta:  ");
    }


    @Override
    public String ProcesarMuestra(int idlab) throws LabNotFoundException{

        Laboratorio laboratorio1 = getLaboratoriobyID(idlab);
        log.info("antes de procesar una muestra:    "+laboratorio1.getColaMuestras());
        Muestra muestraProcesar = laboratorio1.procesarMuestra();
        log.info("despues de procesar una muestra:  "+laboratorio1.getColaMuestras());
        int idPersona = muestraProcesar.getIDpersona();
        Persona persona1 = diccionarioPersonas.get(idPersona);
        persona1.addMuestra(muestraProcesar);
        if (persona1.getNivelSalud().equals("A"))
        {
            return ("Resultado de la Prueba: NEGATIVO, Descripcion: estas en el nivel de la enfermedad menos desarrollada");
        }
        else if (persona1.getNivelSalud().equals("B")){
            return ("Resultado de la Prueba: POSITIVO, Descripcion: No tienes simptomas, pero quedate en casita majo");
        }
        else if (persona1.getNivelSalud().equals("C")){
            return ("Resultado de la Prueba: POSITIVO, Descripcion: Empiezas a tener simptomas, acude al CAP");
        }
        else {
            return ("Resultado de la Prueba: POSITIVO, Descripcion: Ingreso necesario");
        }
    }

    @Override
    public void clear() {
    this.diccionarioPersonas.clear();
    this.laboratorios = new Laboratorio[maxlabs];
    this.numeroMuestras= 0;
    this.numeroLabs=0;
    instance = null;
    log.info("Despues de hacer el clear:    "+ diccionarioPersonas);
    }

    @Override
    public int numeroPersonas() {
        return this.diccionarioPersonas.size();
    }

    @Override
    public int numeroLaboratorios() {
        return this.numeroLabs;

    }

    @Override
    public int numeroMuestras() {
        return this.numeroMuestras ;
    }

    @Override
    public void addLab(Laboratorio lab){
        lab.setIDlab(numeroLabs);
        laboratorios[numeroLabs]=lab;
        numeroLabs++;
    }


}
