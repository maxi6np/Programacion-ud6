package Practica_examen.src.java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Aplicacion {

    public static final String DELIMITADOR = ";";

    public static void main(String[] args) {

        BaseDatosAdministracion baseDatos = leerFichero();
        baseDatos.imprimirOrganismo();
        baseDatos.imprimirEmpleados();
    }

    public static BaseDatosAdministracion leerFichero() {

        BaseDatosAdministracion bd = new BaseDatosAdministracion();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/empleados.csv"))) {

            String linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {
                String[] datosEmpleado = linea.split(DELIMITADOR);
                String nombre = datosEmpleado[0].toLowerCase().trim();
                String apellido1 = datosEmpleado[1].toLowerCase().trim();
                String apellido2 = datosEmpleado[2].toLowerCase().trim();
                String identificacion = datosEmpleado[3].toLowerCase().trim();
                String fechaNacimientoStr = datosEmpleado[4].toLowerCase().trim();
                String consejeria = datosEmpleado[5].toLowerCase().trim();
                String departepartamento = datosEmpleado[6].toLowerCase().trim();
                String categoriaStr = datosEmpleado[7].toLowerCase().trim();
                int salario = Integer.parseInt(datosEmpleado[8].trim());
                int diasVacaciones = Integer.parseInt(datosEmpleado[9].trim());
                int vacacionesDisfrutadas = Integer.parseInt(datosEmpleado[10].trim());

                Categoria categoria = asignarCategoria(identificacion, categoriaStr, salario, diasVacaciones, vacacionesDisfrutadas);
                LocalDate fechaNacimiento = asignarFecha(identificacion, fechaNacimientoStr);

                bd.addEmpleado(nombre, apellido1, apellido2, identificacion, fechaNacimiento, consejeria, departepartamento, categoria);
                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("No se ha podido encontrar el archivo");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ha ocurrido un error a leer el archivo");
        }
        return bd;
    }

    public static Categoria asignarCategoria(String identificador, String categoria, int salario, int diasVacaciones, int vacacionesDisfrutadas) {

        Categoria categoriaAsignada = null;
        switch (categoria) {
            case "superior" -> categoriaAsignada = Categoria.A;
            case "intermedio" -> categoriaAsignada = Categoria.B;
            case "general" -> categoriaAsignada = Categoria.C;
            default -> System.out.println("Empeado " + identificador + "sin categoria asignada");
        }
        ;

        categoriaAsignada.setSalario(salario);
        categoriaAsignada.setVacaciones(diasVacaciones);
        categoriaAsignada.setVacacionesDisfrutadas(vacacionesDisfrutadas);

        return categoriaAsignada;
    }

    public static LocalDate asignarFecha(String identificador, String fechaStr) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("d/M/y"));
            return fecha;
        } catch (DateTimeParseException e) {
            try {
                fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("M-d-y"));
                return fecha;
            } catch (DateTimeParseException e2) {
                try {
                    fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("d/M/y"));
                    return fecha;
                } catch (DateTimeParseException e3) {
                    try {
                        fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("M/d/y"));
                        return fecha;
                    } catch (DateTimeParseException e4) {
                        try {
                            fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("y-M-d"));
                            return fecha;
                        } catch (DateTimeParseException e5) {
                            e3.printStackTrace();
                            System.out.println("No se ha podido convertir la fecha del empleado " + identificador);
                            return null;
                        }
                    }
                }
            }
        }
    }
}
