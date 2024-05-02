package InputOutput;
import java.time.LocalDate;
import java.util.*;

import Excepciones.ExceptionCantidad;
import Modelo.*;

public class Salida{
    
    public Poblacion pedirDatosPoblacion() throws ExceptionCantidad{
        String nombre= Comprobaciones.leerString("Introduce el nombre de la población: ");
        LocalDate fechaInicio= Comprobaciones.leerFecha("Introduce la fecha de incio: ");
        LocalDate fechaFin=Comprobaciones.leerFecha("Introduce la fecha de fin: ");
        int numBacteriasIniciales= Comprobaciones.leerInt("Introduce el número de bacterias iniciales: ");
        double temperatura= Comprobaciones.leerDouble("Introduce la temperatura: ");
        Luminosidad nivelLuz=Comprobaciones.leerLuminosidad("Introduce el nivel de luminosidad {ALTA, MEDIA, BAJA}: ");
        System.out.println("Para la dosis de comida: ");
        Poblacion p = new Poblacion(nombre, fechaInicio, fechaFin, numBacteriasIniciales, temperatura, nivelLuz, pedirDatosDosis());
        return p;
    }

    public void comprobarCantidadComida(int cantidad) throws ExceptionCantidad{
        if(cantidad>=300){
            throw new ExceptionCantidad("La cantidad inicial debe ser un número entero menor de 300");
        }
    }

    public Dosis pedirDatosDosis()throws ExceptionCantidad{
        int cantidadInicial=Comprobaciones.leerInt("Introduce la cantidad inicial de comida: ");
        comprobarCantidadComida(cantidadInicial);
        int diaStopIncremento=Comprobaciones.leerInt("Introduce el día en el que quiere dejar de "+
                    " incrementar la dosis (De entre los 30 que dura el exeprimento): ");
        int dosisDiaStopIncremento=Comprobaciones.leerInt("Introduce la cantidad que quiera dar ese día: ");
        comprobarCantidadComida(dosisDiaStopIncremento);
        int dosisDia30=Comprobaciones.leerInt("Introduce la cantidad final (dia 30): ");
        comprobarCantidadComida(dosisDia30);
        Dosis d = new Dosis(cantidadInicial, diaStopIncremento, dosisDiaStopIncremento, dosisDia30);
        return d;
    }

    public Experimento pedirDatosExperimentos(){
        String nombre= Comprobaciones.leerString("Introduce el nombre del Experimento: ");
        Experimento experimento= new Experimento(nombre, new ArrayList<Poblacion>());
        return experimento;
    }

    public Dosis DatosModificarDosis(Dosis dosis)throws ExceptionCantidad{
        int cantidadInicial=Comprobaciones.leerInt("Introduce la nueva cantidad inicial de comida: ");
        comprobarCantidadComida(cantidadInicial);
        dosis.setCantidadInicial(cantidadInicial);
    
        int diaStopIncremento= Comprobaciones.leerInt("Introduce el día en el que quiere dejar de "+
                    " incrementar la dosis (De entre los 30 que dura el exeprimento): ");
        dosis.setDiaStopIncremento(diaStopIncremento);

        int dosisDiaStopIncremento=Comprobaciones.leerInt("Introduce la cantidad que quiera dar ese día: ");
        comprobarCantidadComida(dosisDiaStopIncremento);
        dosis.setDosisDiaStopIncremento(dosisDiaStopIncremento);
        int dosisDia30=Comprobaciones.leerInt("Introduce la cantidad final (dia 30): ");
        comprobarCantidadComida(dosisDia30);
        dosis.setDosisDia30(dosisDia30);
        return dosis;
    }

}