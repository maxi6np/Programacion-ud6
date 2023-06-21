package Practica_examen.src.java;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BaseDatosAdministracion {

    private Set<Empleado> empleados;
    private Map<Consejeria, Set<Departamento>> organismos;


    public BaseDatosAdministracion() {
        this.empleados = new HashSet<>();
        this.organismos = new HashMap<>();
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Map<Consejeria, Set<Departamento>> getOrganismos() {
        return organismos;
    }

    public void setOrganismos(Map<Consejeria, Set<Departamento>> organismos) {
        this.organismos = organismos;
    }

    public boolean addEmpleado(String nombre, String apellido1, String apellido2, String identificacion, LocalDate fechaNacimiento, String consejeriaStr, String departamentoStr, Categoria categoria) {
        Consejeria consejeriaAsignada;
        Departamento departamentoAsignado;

        if (buscarConsejeria(consejeriaStr) != null) {
            consejeriaAsignada = buscarConsejeria(consejeriaStr);
            if (!organismos.get(consejeriaAsignada).contains(departamentoStr)) {
                organismos.get(consejeriaAsignada).add(new Departamento(consejeriaStr, departamentoStr));
            }

        } else {
            consejeriaAsignada = new Consejeria(consejeriaStr);
            Set<Departamento> dep = new HashSet<>();
            dep.add(new Departamento(consejeriaStr, departamentoStr));
            organismos.put(consejeriaAsignada, dep);
        }

        Empleado nuevoEmpleado = new Empleado(nombre, apellido1, apellido2, identificacion, fechaNacimiento, buscarDepartamento(departamentoStr, consejeriaStr), categoria);

        if (empleados.add(nuevoEmpleado)) {
            departamentoAsignado = buscarDepartamento(departamentoStr, consejeriaStr);
            departamentoAsignado.addEmpleado();
            consejeriaAsignada.addDepartamento(departamentoAsignado);
        }


        return empleados.add(nuevoEmpleado);
    }

    private Empleado buscarEmpleado(final Empleado empleado) {
        for (Empleado e : empleados) {
            if (empleado.equals(e)) {
                return e;
            }
        }
        return null;
    }


    private Consejeria buscarConsejeria(final String consejeria) {
        for (Consejeria c : organismos.keySet()) {
            if (consejeria.equals(c.getNombre())) {
                return c;
            }
        }
        return null;
    }

    private Departamento buscarDepartamento(final String departamentoStr, String consejeriaStr) {
        Consejeria consejeria = buscarConsejeria(consejeriaStr);
        for (Departamento departamento : organismos.get(consejeria)) {
            if (departamentoStr.equals(departamento.getNombre())) {
                return departamento;
            }
        }
        return null;
    }

    public int contabilizarEmpleadostotales(){
        int empleados = 0;
        for (Consejeria consejeria: organismos.keySet()) {
            empleados += consejeria.contabilizarEmpleados();
        }
        return empleados;
    }

    public void imprimirOrganismo() {
        System.out.println("Organismos de la administración");
        for (Consejeria consejeria : organismos.keySet()) {
            System.out.println(consejeria);
            for (Departamento departamento : organismos.get(consejeria)) {
                System.out.println(departamento);
            }
        }
        System.out.println("Empleados totales de la administración: " + contabilizarEmpleadostotales());
    }

    public void imprimirEmpleados() {
        System.out.println("-------------------------------- ----------------------------------------");
        System.out.println();
        System.out.println("Empleados de la administración");
        System.out.println("-------------------------------- ----------------------------------------");

        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }


}
