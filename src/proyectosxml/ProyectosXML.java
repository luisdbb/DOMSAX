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
public class ProyectosXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       
        
        /*
        ESCRITURA Y LECTURA CON DOM
        -------------------------------------------------------
        GeneradorDOM generadorDOM = new GeneradorDOM();
        generadorDOM.generarDocument();
        generadorDOM.generarXml();
        -------------------------------------------------------
        LecturaDOM lecturaDOM = new LecturaDOM("productos.xml");
        lecturaDOM.lecturaXML();
        */        
        
        /*Lectura en JAXB
        
        //Creamos el contexto
        JAXBContext context = JAXBContext.newInstance(LibreriaJAXB.class);
        //Para pasar de XML a JAVA, para poder leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Unmarshall devuelve un object, asique hay que castearlo.
        //Tambien hay que tener en cuenta que este método devolverá la clase del context
        LibreriaJAXB libreria =(LibreriaJAXB) unmarshaller.unmarshal(new File("libreria.xml"));
        
        
        //Mostrar el nombre de la librería del XML
        System.out.println("Nombre del XML: "+libreria.getNombre());
        //Ahora relleno el array con los libros del XML
        ArrayList<Libro> libros = libreria.getLibros();
        for(Libro l: libros){
            System.out.println("ISBN: "+l.getIsbn()
                    +"\nTitulo: "+l.getTitulo()
                    +"\nAutor: "+l.getAutor()
                    +"\n---------------------------------");
        }*/
        
        /*ESCRITURA EN JAXB
        --------------------------------------------------------
        
        //Creamos el contexto. Se le asigna la clase que engloba el XML
        JAXBContext context = JAXBContext.newInstance(LibreriaJAXB.class);
        
        //Para escribir el XML se usa la siguiente clase
        Marshaller marshaller = context.createMarshaller();
        /*Crear la información del fichero con una estructura. Usaremos
        la siguiente clase que ya esta hecha para usarla para el ejemplo
        //LibreriaJAXB libreria = new LibreriaJAXB();
        //libreria.setNombre("Mi Libreria");
        
        //Ahora añado unos libros al XML
        ArrayList<Libro> libros = new ArrayList();
        
        Libro libro1 = new Libro();
        libro1.setIsbn("5867503412");
        libro1.setTitulo("Matemáticas de JAVA");
        libro1.setAutor("Marbella MHS");
        libros.add(libro1);
        
        Libro libro2 = new Libro();
        libro2.setIsbn("09234712398");
        libro2.setTitulo("Pildoras Informaticas");
        libro2.setAutor("Juan el de pildoras");
        libros.add(libro2);
        
        //Ahora cargo los libros en la libreria
        libreria.setLibros(libros);
        
        
        //Para que todo salga en un formato más bonito, se utiliza setProperty
        //Paso Boolean.True en vez de true porque el segundo parámetro pide un object
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        //Ahora se vuelca todo en un XML
        marshaller.marshal(libreria, new FileWriter("miLibreria.xml"));*/
        
        //LECTURA CON SAX
        
        
    /*Primero debemos crear una factoria para poder crear una instancia de SaxParser
    que es el objeto que se usará para leer el .xml*/
        
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();
    
    /*Se le pasa un File y un Handler, el cual es un manejador que define la 
    estructura del XML y cómo hay que leerlo*/
    File file = new File("versiones.xml");
    ManejadorHandler handler = new ManejadorHandler();
    //Este método dejará guardada la información en el ArrayList de ManejadorHandler
    saxParser.parse(file, handler);
    
    //Recogemos la información del ArrayList gracias a su método get
    ArrayList<Version> versiones = handler.getVersiones();
    
    for(Version v:versiones){
        System.out.println(v);
    }
        
    }//Fin de main
}//Fin de clase principal
