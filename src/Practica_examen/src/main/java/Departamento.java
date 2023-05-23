public class Departamento extends Consejeria{

    private String nombre;
    private int empleados;

    public Departamento(String nombreConsejeria, String nombreDepartamento) {
        super(nombreConsejeria);
        this.nombre = nombreDepartamento;
        this.empleados = 0;
    }

    public void addEmpleado(){
        this.empleados++;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getEmpleados() {
        return empleados;
    }

    @Override
    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Departamento ");
        sb.append(nombre);
        sb.append("\nEmpleados: ");
        sb.append(empleados);
        return sb.toString();
    }
}
