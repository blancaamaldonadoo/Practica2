package ClasesLab;
import java.util.*;

import Excepciones.ExcepcionFechas;
import Excepciones.ExceptionCantidad;
import InputOutput.Salida;

public class Experimento implements Interfaces.ManejadorExperimentos {

    private String nombre;
    private ArrayList<Poblacion> poblaciones;
    
    public Experimento(){
        this.poblaciones = new ArrayList<Poblacion>();
    }

    public Experimento(String nombre, ArrayList<Poblacion> poblaciones){
        this.nombre = nombre;
        this.poblaciones = poblaciones;
    }    
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public ArrayList<Poblacion> getPoblaciones(){
            return poblaciones;
    }
        
    public void setPoblaciones(ArrayList<Poblacion> poblaciones){
        this.poblaciones = poblaciones;
    }
    
    public void verDetallesPoblacion(Poblacion p){
        if(poblaciones.contains(p))
        System.out.println(p.toString());
        else System.out.println("No existe la poblacion");
    }

    
    public Poblacion crearPoblacion() throws ExceptionCantidad, ExcepcionFechas{
       Salida salida= new Salida();
       Poblacion p= salida.pedirDatosPoblacion();
       return p;
    }
    
    public String visualizarNombresPoblaciones(){
        String nombres="";
        if(poblaciones.isEmpty()){
            return "No hay poblaciones";
        }
        else{
        for(Poblacion p: poblaciones){
            nombres+=p.getNombre()+"\n";
        }
        return nombres;
        }
    }

    public Poblacion buscarPoblacion(String nombre){
        Poblacion pob=null;
        if(poblaciones.isEmpty()){
            System.out.println("No hay poblaciones en el experimento");
        }
        else{
        for(Poblacion p: poblaciones){
            if(p.getNombre().equals(nombre)){
                pob=p;
                return pob;
            }
        }
    }
        return pob;
    }

    public void addPoblacion(Poblacion p){
        poblaciones.add(p);
    }

    public void eliminarPoblacion(Poblacion p){
        poblaciones.remove(p);
    }
}