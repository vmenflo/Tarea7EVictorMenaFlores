/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author victor
 */
public class Escritura {
    //Método Escribir XML
    public static void generarCatalogoAppXML(List<App> listado) throws JAXBException{
        CatalogoApp catalogo = new CatalogoApp();
        ArrayList<App> lista = new ArrayList(listado);
        catalogo.setLista(lista);
        catalogo.setDescripcion("Mis Apps");
       
        // Crea el contexto JAXB. Se encarga de definir los objetos 
        // que vamos a guardar. En nuestro caso sólo el tipo CatalogoMuebles
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApp.class);
        
        // El contexto JAXB permite crear un objeto Marshaller, que sirve para
        // generar la estructura del fichero XML 
        // El proceso de pasar objetos Java (CatalogoMuebles) a ficheros XML 
        // se conoce como "marshalling" o "serialización"
        Marshaller serializador = contexto.createMarshaller();
        
        // Especificamos que la propiedad del formato de salida
        // del serializador sea true, lo que implica que el formato se 
        // realiza con indentación y saltos de línea
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Llamando al método de serialización marshal (sobrecargado) se pueden
        // serializar objetos java en formato XML y volcarlos donde necesitemos:
        // consola, ficheros. El proceso consiste en que el contexto es el 
        // encargo de leer los objetos java, pasarlos al serializador y éste 
        // crear la salida de serialización
        
        // Serialización y salida por consola
        serializador.marshal(catalogo, System.out);

        // Volcado al fichero xml
        serializador.marshal(catalogo, new File("./datosApp.xml"));
    }

    
//    public static void generarFicheroXML(String idFichero, List<App> lista) throws IOException {
//        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
//            for (int i = 0; i < lista.size(); i++) {
//
//                flujo.write(lista.get(i).toString());
//                flujo.newLine();
//            }
//
//            // Metodo newLine() añade salto de línea después de cada fila
//            flujo.flush();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    //Método JSON
    public static void generarJSON(List<App> listado) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File("./catalogoApp.json"), listado);
    }
    
    //Metodo JSON por cada objeto
     public static void generarFicheroJSONPorObjeto(List<App> lista) throws IOException{
        for (int i = 0; i < lista.size(); i++) {
            for (App app : lista) {
                ObjectMapper mapeador = new ObjectMapper();
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File("./aplicacionesJSON/"+app.getNombre()+".json"), app);
            }
        }
    }

}
