/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Víctor
 */
public class Metodos {
    //Crea 50 aplicaciones usando el constructor por defecto, guárdalas en una 
    //lista y muéstralas por pantalla. 
    public static List<App> generarLista50(){
        //Creamos la lista que se devolverá
        List<App> lista = new ArrayList();
        //Bucle para generar 50 objetos y meterlos en la lista
        for(int i=0; i<50;i++){
            App temporal = new App();
            lista.add(temporal);
        }
        return lista;
    }
    
    //CREAR FICHEROS
    // Este método genera un fichero vacío en la ruta especificada
    public static void crearFichero(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (IOException e) {
            System.out.println("Problema creando el archivo " + ruta);
            System.out.println("Probablemente la ruta esté mal escrita.");
        }
    }
}
