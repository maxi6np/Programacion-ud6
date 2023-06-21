package Practica_examen.src.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String identificacion;
    private LocalDate fechaNacimiento;
    private Departamento departamento;
    private Categoria categoria;

    public Empleado(String nombre, String apellido1, String apellido2, String identificacion, LocalDate fechaNacimiento, Departamento departamento, Categoria categoria) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.departamento = departamento;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nEmpleado: ");
        sb.append(nombre).append(" ");
        sb.append(apellido1).append(" ");
        sb.append(apellido2);
        sb.append("\nIdentificacion: ").append(identificacion);
        sb.append("\nFecha de nacimiento: ").append(fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        sb.append("\nDepartamento:").append(departamento);
        sb.append("\nCategoria: ").append(categoria.name());
        sb.append(categoria);
        return sb.toString();
    }
}
