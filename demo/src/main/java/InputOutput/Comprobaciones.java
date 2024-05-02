package InputOutput;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Modelo.Luminosidad;

public class Comprobaciones {
    
    public static String leerString(String st){ 
        String texto="";
        BufferedReader teclado= new BufferedReader( new InputStreamReader(System.in));
        System.out.println(st);
        try {
            texto=teclado.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer el texto");
            e.printStackTrace();
    }
        return texto;
    }

    public static int leerInt(String i){
        int numero=0;
        BufferedReader teclado= new BufferedReader( new InputStreamReader(System.in));
        System.out.println(i);
        try {
            numero=Integer.parseInt(teclado.readLine());
        } catch (IOException e) {
            System.out.println("Error al leer el número");
            e.printStackTrace();
        }
        return numero;
    }

    public static double leerDouble(String d){
        double numero=0;
        BufferedReader teclado= new BufferedReader( new InputStreamReader(System.in));
        System.out.println(d);
        try {
            numero=Double.parseDouble(teclado.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Número no válido");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error al leer el número");
            e.printStackTrace();
        }
        return numero;  
    }

    public static LocalDate leerFecha(String f){
        LocalDate fecha=null;
        BufferedReader teclado= new BufferedReader( new InputStreamReader(System.in));
        System.out.println(f);
        try {
            fecha=LocalDate.parse(teclado.readLine());
            DateTimeFormatter tipo= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            fecha= LocalDate.parse(teclado.readLine(), tipo);
        } catch (IOException e) {
            System.out.println("Error al leer la fecha");
            e.printStackTrace();
        }
        return fecha;
    }

    public static Luminosidad leerLuminosidad(String l){
        Luminosidad nivelLuz=null;
        BufferedReader teclado= new BufferedReader( new InputStreamReader(System.in));
        System.out.println(l);
        try {
            nivelLuz= Luminosidad.valueOf(teclado.readLine().toUpperCase());
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error al leer el nivel de luz");
            e.printStackTrace();
        }   
        return nivelLuz;
    }
}
