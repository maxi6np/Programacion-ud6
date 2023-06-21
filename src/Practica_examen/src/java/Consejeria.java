package Practica_examen.src.java;

import java.util.HashSet;
import java.util.Set;

public class Consejeria {

    private String nombre;
    private Set<Departamento> departamentos;
    private int empleados;

    public Consejeria(String nombre) {
        this.nombre = nombre;
        this.departamentos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    public int contabilizarEmpleados(){
        empleados = 0;
        for (Departamento departamento: departamentos) {
           this.empleados += departamento.getEmpleados();
        }
        return empleados;
    }


    public boolean addDepartamento(Departamento departamento){
        return departamentos.add(departamento);
    }

    @Override
    public String toString() {
        contabilizarEmpleados();
        final StringBuilder sb = new StringBuilder("\n\nConsejeria ");
        sb.append(nombre);
        sb.append("\nEmpleados: ");
        sb.append(contabilizarEmpleados());
        return sb.toString();
    }
}
