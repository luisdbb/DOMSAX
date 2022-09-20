package proyectosxml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Esta clase nos muestra cómo crear la estructura necesaria para crear la
 * lectura con JAXB en JAVA.
 */

//Defino el elemento Root del xml, su parámetro debe coincidir con el del xml.
@XmlRootElement(name = "libreria")
@XmlType(propOrder = { "nombre", "libros" })
public class LibreriaJAXB {
	// Al igual que el archivo libreria.xml, se establece la estructura en esta
	// clase
	private String nombre;
	private ArrayList<Libro> libros = new ArrayList();

	// Constructor
	// -------------------------------------------------------------------------
	public LibreriaJAXB() {
	}

	/*
	 * MÉTODOS SET ANG GET
	 * ---------------------------------------------------------------------------
	 */
	@XmlElement(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Hay que definir que libros es una etiqueta envoltorio. Se hace así:
	@XmlElementWrapper(name = "libros")
	// Aquí defino cada elemento que irá dentro del wraper o envoltorio
	@XmlElement(name = "libro")
	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

}
