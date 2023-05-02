package GeneradorPersonas;

public class Persona {
	private String nombre;

	// Dos apellidos, separados por un espacio
	private String apellidos;
	private int edad;

	public Persona(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Nombre= ").append(nombre);
		sb.append(", apellidos= ").append(apellidos);
		sb.append(", edad= ").append(edad);
		return sb.toString();
	}
}
