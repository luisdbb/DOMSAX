package proyectosxml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class EjemploSAX {

	public static void main(String[] args) throws Exception {
        //LECTURA CON SAX
        
        /*Primero debemos crear una factoria para poder crear una instancia de SaxParser
        que es el objeto que se usará para leer el .xml*/
            
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        
        /*Se le pasa un File y un Handler, el cual es un manejador que define la 
        estructura del XML y cómo hay que leerlo*/
        File file = new File("ficheros\\versiones.xml");
        ManejadorHandler handler = new ManejadorHandler();
        //Este método dejará guardada la información en el ArrayList de ManejadorHandler
        saxParser.parse(file, handler);
        
        //Recogemos la información del ArrayList gracias a su método get
        ArrayList<Version> versiones = handler.getVersiones();
        
        for(Version v:versiones){
            System.out.println(v);
        }

	}

}
