/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasXml;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author hinda
 */
public class LeerXml {
    public static void main(String[] args) throws JAXBException {
         // Crea el contexto JAXB 
        JAXBContext contexto = JAXBContext.newInstance(CatalogoMuebles.class);
        // Crea el objeto Unmarshaller
        Unmarshaller um = contexto.createUnmarshaller();

        // Llama al método de unmarshalling
        CatalogoMuebles catalogo = (CatalogoMuebles) um.unmarshal(new File("catalogo.xml"));

        ArrayList<Mueble> listaMuebles = catalogo.getListaMuebles();

        listaMuebles.forEach(System.out::println);
    }
}
