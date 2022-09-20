
package proyectosxml;

public class EjemploDOM {

    public static void main(String[] args) throws Exception {

        /*
        ESCRITURA Y LECTURA CON DOM
        */
        GeneradorDOM generadorDOM = new GeneradorDOM();
        generadorDOM.generarDocument();
        generadorDOM.generarXml();
        
        LecturaDOM lecturaDOM = new LecturaDOM("ficheros\\productos.xml");
        lecturaDOM.lecturaXML();

        
    }
}
