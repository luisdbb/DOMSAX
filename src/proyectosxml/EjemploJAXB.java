package proyectosxml;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class EjemploJAXB {

	public static void main(String[] args) throws Exception{
        //Lectura en JAXB
        
        //Creamos el contexto
        JAXBContext context = JAXBContext.newInstance(LibreriaJAXB.class);
        //Para pasar de XML a JAVA, para poder leer el XML
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Unmarshall devuelve un object, asique hay que castearlo.
        //Tambien hay que tener en cuenta que este método devolverá la clase del context
        LibreriaJAXB libreria =(LibreriaJAXB) unmarshaller.unmarshal(new File("ficheros\\libreria.xml"));
        
        
        //Mostrar el nombre de la librería del XML
        System.out.println("Nombre del XML: "+libreria.getNombre());
        //Ahora relleno el array con los libros del XML
        ArrayList<Libro> libros = libreria.getLibros();
        for(Libro l: libros){
            System.out.println("ISBN: "+l.getIsbn()
                    +"\nTitulo: "+l.getTitulo()
                    +"\nAutor: "+l.getAutor()
                    +"\n---------------------------------");
        }
        
        //ESCRITURA EN JAXB
        //--------------------------------------------------------
        
        //Creamos el contexto. Se le asigna la clase que engloba el XML
        JAXBContext context2 = JAXBContext.newInstance(LibreriaJAXB.class);
        
        //Para escribir el XML se usa la siguiente clase
        Marshaller marshaller = context2.createMarshaller();
        /*Crear la información del fichero con una estructura. Usaremos
        la siguiente clase que ya esta hecha para usarla para el ejemplo
        */
        LibreriaJAXB libreria2 = new LibreriaJAXB();
        libreria2.setNombre("Mi Libreria");
        
        //Ahora añado unos libros al XML
        ArrayList<Libro> librosB = new ArrayList();
        
        Libro libro1 = new Libro();
        libro1.setIsbn("5867503412");
        libro1.setTitulo("Matemáticas de JAVA");
        libro1.setAutor("Marbella MHS");
        librosB.add(libro1);
        
        Libro libro2 = new Libro();
        libro2.setIsbn("09234712398");
        libro2.setTitulo("Pildoras Informaticas");
        libro2.setAutor("Juan el de pildoras");
        librosB.add(libro2);
        
        //Ahora cargo los libros en la libreria
        libreria2.setLibros(librosB);
        
        
        //Para que todo salga en un formato más bonito, se utiliza setProperty
        //Paso Boolean.True en vez de true porque el segundo parámetro pide un object
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        //Ahora se vuelca todo en un XML
        marshaller.marshal(libreria2, new FileWriter("ficheros\\miLibreria.xml"));
        
        
   
	}

}
