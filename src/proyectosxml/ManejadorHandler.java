/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectosxml;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Alejandro Exposito Ortiz
 */

//Creamos el Handler. Para ello, esta clase debe heredar de DefaultHandler y sus métodos.

public class ManejadorHandler extends DefaultHandler{

    /*Para poder progamar lo que hacen los métodos, antes voy a ver cuáles
    son los datos que tiene mi archivo versiones.xml. Para ello usaré un
    ArrayList donde guardar la información.
    */
    private ArrayList<Version> versiones = new ArrayList();
    //Creo una variable Version auxiliar para ir cargándolo en el ArrayList
    private Version version;
    //Usar Bufer para leer los elementos que tienen texto
    private StringBuilder buffer = new StringBuilder();
    
    
    
    //Método para reconocer los caracteres
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
        //Guardo la indormación del String en el buffer
            buffer.append(ch,start,length);
    }

    //Método para reconocer las etiquetas de cierre
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
        switch(qName){
            case "nombre":
                //Al cerrar, cargamos lo que tiene el buffer en el objeto version
                version.setNombre(buffer.toString());
                break;
            case "api":
                //El resultado de toSting se pasa a entero porque asi es en el xml
                version.setApi(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    
    //Este método para poder acceder al ArrayList desde fuera
    public ArrayList<Version> getVersiones() {
        return versiones;
    }

    //Método para reconocer las etiquetas de apertura
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        
     //El qName recibe el nombre del elemento, en este XML hay estos 4:
        switch(qName){
            
            case "version":
                version = new Version();
                versiones.add(version);
                /*El parámetro attributes recibe el atributo del elemento
                Con el metodo getValues, cojo el valor del atributo. Pero se
                devuelve un double del xml, asique hay que parsearlo*/
                version.setNumero(Double.parseDouble(attributes.getValue("numero")));
                break;
            case "nombre":
                /*Ahora vacío el buffer desde el inicio hasta el final para que
                a la próxima lectura de texto, no haya conflictos*/
                buffer.delete(0, buffer.length());
                break;
            case "api":
                 buffer.delete(0, buffer.length());
                break;
              
        }
    }
    
}
