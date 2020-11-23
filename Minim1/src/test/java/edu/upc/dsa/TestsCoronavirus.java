
package edu.upc.dsa;

import java.util.List;

import edu.upc.dsa.models.LabNotFoundException;
import edu.upc.dsa.models.Laboratorio;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Persona;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class TestsCoronavirus {
    private Covid19Manager corona;
    @Before
    public void setUp(){
        this.corona = Covid19ManagerImpl.getInstance();
        this.corona.addPersona(new Persona("Axel","Rodríguez",1,21,"B"));
        this.corona.addPersona(new Persona("Pedro","Sanchez",2,22,"A"));
        this.corona.addPersona(new Persona("Manuel","Mateo",3,25,"B"));
        this.corona.addPersona(new Persona("Agata","Tirado",4,56,"D"));
        this.corona.addPersona(new Persona("Francisco","Ferrer",5,35,"C"));
        this.corona.addLab(new Laboratorio("pfizer"));

    }

    @After
    public void tearDown(){
        this.corona.clear();
    }

    @Test
    public void nuevoUsuario(){
        this.corona.addPersona(new Persona("Antonio","Rodríguez",6,87,"D"));
        Assert.assertEquals(6,this.corona.numeroPersonas());
    }

    @Test
    public void ProcesarMuestra() throws LabNotFoundException {
        Muestra primera = new Muestra(1,1,1,"2020/05/24",1);
        Muestra segunda = new Muestra(2,2,3,"2020/05/15",1);
        Muestra tercera = new Muestra(3,3,2,"2020/05/30",1);

        this.corona.enviarMuestra(primera);
        this.corona.enviarMuestra(segunda);
        this.corona.enviarMuestra(tercera);

        this.corona.ProcesarMuestra(1);

        Assert.assertEquals(3,this.corona.numeroMuestras());
    }
}
