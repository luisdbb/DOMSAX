/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosxml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 122bd
 */
public class LecturaDOM {

    //Ojeto donde se almacenará el XML
    Document document;
    
    public LecturaDOM(String ruta) throws FileNotFoundException, ParserConfigurationException, SAXException, IOException{
        
        //Constructor de clase
        File arXML = new File(ruta);
        
        //Creamos los objetos para poder leer el fichero
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        
        //Transferimos el XML al objeto document
        document= builder.parse(arXML);
        //Usamos el método normalize para dar formato al texto
        document.getDocumentElement().normalize();
        
        
    }
    /*
    Método para leer el xml que hemos pasado al constructor
    ----------------------------------------------------------------------------------------
    */
    public void lecturaXML(){
        //Obtenemos el nombre del nodo (o etiqueta) raíz
        System.out.println("Nombre documento: "+document.getDocumentElement().getNodeName());
        
        /*
        Creamos una lista donde se almacenarán los datos. Los elementos se buscarán mediante
        las subetiquetas de la principal. Por ejemplo:
            <Concesionario>
                <Coche> name = "Deportivos">
                    <item name="Marca"> Seat </item>
                    <item name="Peso"> 1000 </item>
                    <item name="Color"> Amarillo </item>
                </Coche> 
            </Concesionario>
        
        Aquí escogeríamos la etiqueta Coche para recorrer los datos en el NodeList
        */
        NodeList nodeList = document.getElementsByTagName("producto");
        //También debemos instanciar un elemento Node para leer los elementos del NodeList
        Node node;
        
        //Creo el bucle para recorrer todos los elementos del NodeList
        for(int i=0; i<nodeList.getLength();i++){
           node = nodeList.item(i);
           
           /*
           Ahora se revisan los nodos. Hay diferentes tipos de nodos: Los de tipo elemento 
           (etiquetas), los de tipo atributo, de texto, de tipo documento, etc. En este if
           se va a ejecutar el código del interior siempre que el nodo sea de tipo Element,
           es decir, siempre que sea una etiqueta. Con la constante ELEMENT_NODE 
           identificamos las etiquetas de tipo elemento.
           */
           if(node.getNodeType() == Node.ELEMENT_NODE){
               Element element = (Element) node;
               //En esta línea recojo el atributo del documento.
               System.out.println("Nombre: "+element.getAttribute("Nombre"));
               //En esta línea recojo los items anidados dentro de las etiquetas de "productos"
               System.out.println("peso: "+element.getElementsByTagName("peso").item(0).getTextContent());
           }
           
        }
        
    }
    
}
