/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
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
    
    //BORRAR ARCHIVO
        public static void borrarElemento(String ruta) {
        Path file = Paths.get("./aplicacionesJSON/"+ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }
    
    //COMPROBAR SI EXISTE UN ARCHIVO
        public static boolean existeArchivo(String nombre){
            return Files.exists(Paths.get("./aplicacionesJSON/"+nombre));
        }
}
