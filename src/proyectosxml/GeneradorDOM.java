package proyectosxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class GeneradorDOM {
	// En esta variable se guardará el xml
	private Document document;

	// Constructor de clase
	public GeneradorDOM() throws ParserConfigurationException {
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		// Aquí es donde creo el documento gracias a Builder
		document = builder.newDocument();
	}

	/*
	 * Método para generar documento
	 * -----------------------------------------------------------------------------
	 * -
	 * 
	 * Aquí es donde irá el esqueleto del XML
	 */
	public void generarDocument() {
		// Todos los nodos del árbol XML son de tipo Element

		// Este es el elemento raíz, por lo que se pondrá como hijo del document
		// con appendChild
		Element productos = document.createElement("productos");
		// Aquí hay que pasar un elemento de tipo NODE
		document.appendChild(productos);

		// Ahora añado un elemento hijo de productos
		// Item 1
		Element producto = document.createElement("producto");
		productos.appendChild(producto);
		producto.setAttribute("Nombre", "Manzana");
		// Para añadir items.

		Element peso = document.createElement("peso");
		peso.appendChild(document.createTextNode("150"));
		producto.appendChild(peso);

		// Item 2
		Element producto2 = document.createElement("producto");
		productos.appendChild(producto2);
		producto2.setAttribute("Nombre", "Pechuga de pollo");
		Element peso2 = document.createElement("peso");
		peso2.appendChild(document.createTextNode("500"));
		producto2.appendChild(peso2);

		// Item 3
		Element producto3 = document.createElement("producto");
		productos.appendChild(producto3);
		producto3.setAttribute("Nombre", "Palomitas");
		Element peso3 = document.createElement("peso");
		peso3.appendChild(document.createTextNode("35"));
		producto3.appendChild(peso3);

	}

	/*
	 * Método para generar el XML
	 * -----------------------------------------------------------------------------
	 */
	public void generarXml() throws TransformerConfigurationException, IOException, TransformerException {

		// Para poder hacer generar el xml hay que trnasformar la información
		TransformerFactory factoria = TransformerFactory.newInstance();
		Transformer transformer = factoria.newTransformer();

		// Ahora debemos crear un "Source" y un "Result" para el método transform

		// Uso el constructor que te pide un NODE, porque document hereda de NODE
		// --------------------
		Source source = new DOMSource(document);

		// Para el result
		// --------------------
		File file = new File("ficheros\\productos.xml");
		FileWriter fw = new FileWriter(file);
		// Este es el objeto que a usar el Result para generar el documento
		PrintWriter pw = new PrintWriter(fw);
		Result result = new StreamResult(pw);

		transformer.transform(source, result);
	}

}
