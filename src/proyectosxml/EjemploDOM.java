/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author 122bd
 */
public class EjemploDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        
        /*
        ESCRITURA Y LECTURA CON DOM
        -------------------------------------------------------
        */
        GeneradorDOM generadorDOM = new GeneradorDOM();
        generadorDOM.generarDocument();
        generadorDOM.generarXml();
        
        LecturaDOM lecturaDOM = new LecturaDOM("ficheros\\productos.xml");
        lecturaDOM.lecturaXML();

        
    }//Fin de main
}//Fin de clase principal
