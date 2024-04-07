/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author victor
 */
public class Lectura {
    //MÉTODO PARA LEER UN FICHERO XML
        public static void leerXML(String file) throws JAXBException, FileNotFoundException{
        
        // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApp.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        CatalogoApp catalogo = (CatalogoApp) um.unmarshal(new File(file));

        ArrayList<App> listaApp = catalogo.getListaApp();

        listaApp.forEach(System.out::println);
    }
    
    //METODO PARA LEER UN FICHERO JSON
    public static void leerJSON(String file) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<App> catalogoDeJSON = mapeador.readValue(new File(file),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));
        
        for (App catalogoApp : catalogoDeJSON) {
            System.out.println(catalogoApp);
        }
    }
    
    //Método para listar un directorio
    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }
    
    public static void leerJSONConcreto(String file) throws IOException{
        
            ObjectMapper mapeador = new ObjectMapper();
            mapeador.registerModule(new JavaTimeModule());

            App aplicacion = mapeador.readValue(new File("./aplicacionesJSON/"+file), App.class);

            System.out.println(aplicacion);
}
}
