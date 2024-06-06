package Controlador;
import java.io.File;
import java.util.*;

import InputOutput.*;
import ClasesLab.*;


public class Laboratorio {

    private ArrayList<Experimento> experimentos;
    private Experimento experimentoActual;
    private ArrayList<Archivos> archivos;

    public Laboratorio(){
        this.experimentoActual=null;
        this.archivos= new ArrayList<Archivos>();
        this.experimentos = new ArrayList<Experimento>();
    }

    public ArrayList<Experimento> getExperimentos(){
        return experimentos;
    }

    public void setExperimentos(ArrayList<Experimento> experimentos){
        this.experimentos = experimentos;
    }

    public ArrayList<Archivos> getArchivos(){
        return archivos;
    }

    public Experimento getExperimentoActual(){
        return experimentoActual;
    }

    public void setExperimentoActual(Experimento experimentoActual){
        this.experimentoActual = experimentoActual;
    }
    
    public void addArchivo(Archivos a){
        this.archivos.add(a);
    }

    public boolean archivoExist(String nombre){
        for(Archivos a: archivos){
            if(a.getArchivo().getName().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    public File getArchivo(String nombre){
        for(Archivos a: archivos){
            if(a.getArchivo().getName().equals(nombre)){
                return a.getArchivo();
            }
        }
        return null;
    }
    
    public Experimento crearExperimento(){
        Salida salida = new Salida();
        Experimento e= salida.pedirDatosExperimentos();
        experimentos.add(e);
        experimentoActual=e;    
        System.out.println("Bienvenido al experimento: '" +e.getNombre() + "'");
        return e;
    }

    public Experimento buscarExperimento(){
        String nombre= Comprobaciones.leerString("Introduce el nombre del experimento: ");
        for(Experimento e: experimentos){
            if(e.getNombre().equals(nombre)){
                return e;
            }
        }
        System.out.println("No existe ningún experimento con ese nombre");
        return null;
    }

    public Experimento cambiarNombreExperimento(Experimento experimento){
        String nombre=Comprobaciones.leerString("Introduce el nuevo nombre del Experimento: ");
        if(nombre.isEmpty()){
            System.out.println("No se ha introducido ningún nombre");
            return experimento;
        }
        for(Experimento e: experimentos){
            if(e.getNombre().equals(nombre)){
                System.out.println("Ya existe un experimento con ese nombre");
                return experimento;
            }
        }
        experimento.setNombre(nombre);
        return experimento;
    }

    public void addExperimento(Experimento e){
        experimentos.add(e);
        experimentoActual=e;
    }


    public void eliminarExperimento(Experimento e){
        experimentos.remove(e);
    }

}