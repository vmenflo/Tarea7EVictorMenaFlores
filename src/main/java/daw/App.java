/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 *
 * @author victor
 */
public class App {

    //Atributos
    private int codigo;
    private static int sumatoria=0;
    private static String[] prefijos = {"css", "hth", "ssh", "ty", "lop", "gss", "asd", "hyy", "jjt", "hol"};
    private String nombre;
    private String descripcion;
    private double tamaño;
    private int numeroDescargas;

    //Constructor parametrizado
    public App(String nombre, String descripcion, double tamaño, int numeroDescargas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamaño = tamaño;
        this.numeroDescargas = numeroDescargas;
    }

    //Constructor por defecto
    public App() {
        Random r = new Random();
        this.codigo=sumatoria++;
        this.nombre = "App" + this.codigo + (char) r.nextInt(97, 122);
        this.descripcion = prefijos[r.nextInt(0, 10)];
        this.tamaño = r.doubles(1, 100.0, 1024.0).findFirst().getAsDouble();
        this.numeroDescargas = r.ints(1, 0, 50000).findFirst().getAsInt();
    }
    //Getter and Setter

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public static int getSumatoria() {
        return sumatoria;
    }

    public static void setSumatoria(int sumatoria) {
        App.sumatoria = sumatoria;
    }

    public static String[] getPrefijos() {
        return prefijos;
    }

    public static void setPrefijos(String[] prefijos) {
        App.prefijos = prefijos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(int numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }


   
    //Equals and hashcode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.descripcion);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.tamaño) ^ (Double.doubleToLongBits(this.tamaño) >>> 32));
        hash = 41 * hash + this.numeroDescargas;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final App other = (App) obj;
        if (Double.doubleToLongBits(this.tamaño) != Double.doubleToLongBits(other.tamaño)) {
            return false;
        }
        if (this.numeroDescargas != other.numeroDescargas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }
    
    //To String

    @Override
    public String toString() {
        return codigo+";"+nombre + ";" + descripcion + ";" + tamaño + ";" + numeroDescargas + ";";
    }
    
}
