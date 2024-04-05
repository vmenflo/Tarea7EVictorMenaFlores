/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author victor
 */
public class Lectura {
    //Leer
    
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
}
