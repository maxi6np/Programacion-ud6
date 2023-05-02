package Parking;


import java.util.Scanner;

public class Main {
    static Parking parking = new Parking("Máximo", 10);
    static Scanner sc = new Scanner(System.in);
    static int opcion;

    public static void menu() {
        System.out.println("""
                ------------------------
                1) Entrada el coche
                2) Salida del coche
                3) Mostrar parking
                4) Salir del programa
                -->
                """);
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            opcion = 0;
            //Poniendo la opcion a 0, el programa se dirige al default de "accion()"
        }

        switch (opcion) {
            case 1 -> entradaCoche();
            case 2 -> salidaCoche();
            case 3 -> System.out.println(parking + "\n");
            case 4 -> System.out.println("Fin del programa \n");
            default -> System.out.println("ERROR! Introduzca una opción válida");
        }
    }

    private static void entradaCoche() {
        boolean correcto = false;
        try {
            //Código que puede dar problemas
            System.out.println("Introduzca la matrícula");
            String m = sc.nextLine();
            System.out.println("Introduzca la plaza");
            int p = Integer.parseInt(sc.nextLine());
            parking.entrada(m, p);
            correcto = true;

        } catch (ParkingException e) {
            //Si hubiese algún error Parking Execption lo maneja
            System.err.println("ERROR: " + e.getMensaje());
            System.out.println("No se realizó la entrada del coche con la matrícula '" + e.getMatricula() + "' en el parking");
        } catch (Exception e) {
            //Se gestionan los errores que no entren en ParkingException, errores generales
            System.err.println("Error desconocido");
        } finally {
            // Si fue correcto no salta nada, si algo falla lo decimos
            if (!correcto) {
                System.out.println("Se produjo un error");
            }
        }
    }

    private static void salidaCoche() {
        //Creamos "correcto" para comprobar que funciona bien
        boolean correcto = false;
        try {
            System.out.println("Introduzca la matrícula:");
            //Guardamos la matricula que pasa el usuario
            String m = sc.nextLine();
            //Guardamos la plaza que pasa el usuario
            int p = parking.salida(m);
            System.out.println("El coche con matrícula '" + m + "' salió de la plaza " + p);

            System.out.println("Plazas libres: " + parking.getPlazasLibres());
            System.out.println("Plazas ocupadas: " + parking.getPlazasOcupadas());
            System.out.println("Plazas totales: " + parking.getPlazasTotales());

            correcto = true;

        } catch (ParkingException e) {
            System.err.println("ERROR: " + e.getMensaje());
            System.out.println("No se realizó la salida del coche con matrícula '" + e.getMatricula() + "' del parking");
        } catch (Exception e) {
            System.err.println("Error desconocido");
        } finally {
            // Si fue correcto no salta nada, si algo falla lo decimos
            if (!correcto) {
                System.out.println("Se produjo un error");
            }
        }
    }


    public static void main(String[] args) throws ParkingException {
        do {
            menu();
        } while (opcion != 4);
    }
}
