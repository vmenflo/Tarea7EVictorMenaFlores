/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import javax.xml.bind.JAXBException;

/**
 *
 * @author victor
 */
public class Prueba {
    
    public static void main(String[] args) throws IOException, JAXBException {

//Crea 50 aplicaciones usando el constructor por defecto, guárdalas en una 
//lista y muéstralas por pantalla. 
        List<App> lista = Metodos.generarLista50();
        System.out.println(lista);
//Genera en la raíz del proyecto, a partir de la lista de Apps, un fichero XML 
//con los datos de todas las aplicaciones.
        Escritura.generarCatalogoAppXML(lista);

//Genera en la raíz del proyecto, a partir de la lista de Apps, un fichero JSON
//        con los datos de todas las aplicaciones.
        Escritura.generarJSON(lista);
//Genera tantos archivos JSON como aplicaciones haya en la lista en una carpeta 
//        llamada ./aplicacionesJSON. El nombre de cada archivo será el nombre 
//                de la aplicación en cuestión.

        Directorios.crearDirectorio("aplicacionesJSON");
        Escritura.generarFicheroJSONPorObjeto(lista);

//Realiza una lectura del fichero XML y muestra los datos de todas las apps por consola.
        System.out.println("Lectura del fichero datosApp.xml---------------");
        Lectura.leerXML("./datosApp.xml");

//Realiza una lectura del fichero JSON y muestra los datos de todas las apps por consola.
        System.out.println("Lectura del fichero catalogoApp.json------------");
        Lectura.leerJSON("catalogoApp.json");

//Muestra un listado de los ficheros que hay en ./aplicacionesJSON. 
        Lectura.listarDirectorio("./aplicacionesJSON");
        
//Pregunta al usuario el nombre del fichero json (de los anteriores) que quiere leer. 
//Una vez leído muestra los datos de esta app por consola.
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Qué archivo quieres leer?");
        String archivo = teclado.nextLine();
        Lectura.leerJSONConcreto(archivo);
        
    
//Borra el archivo leído y comprueba que ya no está en el directorio ./aplicacionesJSON.
        System.out.println("¿Qué archivo quieres borrar?");
        String aBorrar = teclado.nextLine();
        Metodos.borrarElemento(aBorrar);
        System.out.println("¿Qué archivo deseas comprobar?");
        String nombre = teclado.nextLine();
        System.out.println("¿Existe ese archivo?" + Metodos.existeArchivo(nombre));
    }

}
