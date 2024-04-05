/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 *
 * @author Víctor
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoApp {
        // XmLElementWrapper define un contenedor para la lista 
    // de apps
    @XmlElementWrapper(name = "catalogo")

    // XmlElement establece el nombre de los elementos
    // Cada elemento de la lista llevará esta etiqueta en el fichero xml
    @XmlElement(name = "app")
    private ArrayList<App> listaApp;

    private String descripcion;

    public CatalogoApp() {
    }

    public ArrayList<App> getListaApp() {
        return listaApp;
    }

    public void setLista(ArrayList<App> lista) {
        this.listaApp = lista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
