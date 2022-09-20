package proyectosxml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * Esta clase sirve para configurar la estructura de cada libro del archivo
 * libreria.xml
 */

//La clase Libro en realidad es un rootElement de los items de dentro
@XmlRootElement(name = "libro")
//Libro está compuesto por una serie de elementos en un orden. Se representa así:
@XmlType(propOrder = { "isbn", "titulo", "autor" })
class Libro {

	private String isbn;
	private String titulo;
	private String autor;

	// Constructor
	public Libro() {
	}

	/*
	 * MÉTODOS SET ANG GET
	 * ---------------------------------------------------------------------------
	 */

	// Hay que definirlo como atributo
	@XmlAttribute(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
