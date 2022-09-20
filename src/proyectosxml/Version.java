package proyectosxml;

//Aquí vamos a definir cuáles son los datos que contiene versiones.xml
class Version {
	private double numero;
	private String nombre;
	private int api;

	/*
	 * CONSTRUCTOR DE CLASE
	 */
	public Version() {
	}

	/*
	 * MÉTODOS GET AND SET
	 */
	public double getNumero() {
		return numero;
	}

	public void setNumero(double numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getApi() {
		return api;
	}

	public void setApi(int api) {
		this.api = api;
	}

	/*
	 * MÉTODO TO_STRING
	 */
	@Override
	public String toString() {
		return "Version{" + "numero=" + numero + ", nombre=" + nombre + ", api=" + api + '}';
	}

}
