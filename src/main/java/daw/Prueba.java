/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.util.List;
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
        Lectura.leerXML("./datosApp.xml");
    }
    
}
