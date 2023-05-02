package GeneradorPersonas;

import java.util.*;

public class GeneradorPersonas {
    private static final String[] NOMBRES = {"Hugo", "Emma", "Carmen", "Daniel", "Sofía", "Alejandro", "Leo", "Julia",
            "Aitana", "Jorge"};
    private static final String[] APELLIDOS = {"Álvarez", "Gallego", "Muñoz", "Tudela", "Sánchez", "Busquets", "Rojas",
            "Castillo", "Martín", "Alba", "Roberto", "Arrizabalaga", "Cruz", "Barroso", "Gil", "Blanco", "Romero",
            "Moro"};
    private static final int MIN_EDAD = 18;
    private static final int MAX_EDAD = 110;


    /**
     * Genera un listado aleatorio de personas, sin repetir nombres pero sin ninguna
     * limitación respecto a los apellidos. Se les asigna una edad aleatoria entre
     * los dos valores límite. Si se solicita un número de personas superior al
     * número de nombres disponibles, sí que se podrán repetir nombres
     *
     * @param nPersonas
     * @return
     */
    public static final List<Persona> genera(int nPersonas) throws NumNegativoPersonasException {
        List<Persona> personasNuevas = new ArrayList<>();
        List<String> nombresUsados = new ArrayList<>();
        Random random = new Random();
        String nombre = "";
        String apellidos = "";

        if (nPersonas <= 0){
            throw new NumNegativoPersonasException("No se puede pedir un número de personas negativo o 0", nPersonas);
        }
        for (int i = 0; i < nPersonas; i++) {
            if (nPersonas <= NOMBRES.length) {
                nombre = NOMBRES[random.nextInt(NOMBRES.length)];
                while (nombresUsados.contains(nombre)) {
                    nombre = NOMBRES[random.nextInt(NOMBRES.length)];
                }
                nombresUsados.add(nombre);
            } else {
                nombre = NOMBRES[random.nextInt(NOMBRES.length)];
            }

            String apellido1 = APELLIDOS[random.nextInt(APELLIDOS.length)];
            String apellido2 = APELLIDOS[random.nextInt(APELLIDOS.length)];
            apellidos = apellido1.concat(" ").concat(apellido2);

            int edad = random.nextInt(MAX_EDAD - MIN_EDAD) + MIN_EDAD;
            Persona persona = new Persona(nombre, apellidos, edad);
            personasNuevas.add(persona);
        }

        return personasNuevas;
    }


}
