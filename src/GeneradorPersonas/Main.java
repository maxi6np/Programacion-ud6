package GeneradorPersonas;

import java.util.*;

public class Main{
    private static final List<Persona> personas = new ArrayList<>();

    public static void main(String[] args){
        generarPersonas(-4);
        //mostrarPersonas(personas);
        //System.out.println(personasPorNombre());
        //System.out.println(personasPorApellidos());
        //System.out.println(repeticionApellidos());
        //mostrarMapaSimple(repeticionApellidos());
        //System.out.println(personasPorRangoEdad());
        //mostrarMapaConLista(personasPorRangoEdad());
        //System.out.println(borrarPorEdad(70,90));
    }

    /**
     * Genera un listado de personas con nombres y apellidos aleatorios y lo asigna
     * al atributo personas
     *
     * @param nPersonas personas que se quieren generar
     */
    private static void generarPersonas(int nPersonas){
        //personas.addAll(GeneradorPersonas.genera(nPersonas));
        try{
            GeneradorPersonas.genera(nPersonas);
            System.out.println("El número de personas el válido");
        }catch (NumNegativoPersonasException e){
            System.err.println(e.getMensaje());
        }
    }

    /**
     * Muestra por pantalla el listado de personas recibido por parámetro con el
     * siguiente formato: Apellido1 Apellido2, Nombre
     */
    private static void mostrarPersonas(List<Persona> personas) {
        List<String> formatoApellidos = new ArrayList<>();

        for (Persona p : personas) {
            String nombre = p.getNombre();
            String apellidos = p.getApellidos();
            String resultado = apellidos.concat(", ").concat(nombre);
            formatoApellidos.add(resultado);
        }
        System.out.println(formatoApellidos);

    }

    /**
     * Devuelve un listado de personas ordenado alfabéticamente por nombre sin
     * modificar el listado original
     *
     * @return listado ordenado
     */
    private static List<Persona> personasPorNombre() {
        List<Persona> personasPorNombre = new ArrayList<>(personas);
        personasPorNombre.sort(new ComparadorNombres());
        return personasPorNombre;
    }

    /**
     * Devuelve un listado de personas ordenado alfabéticamente por apellidos sin
     * modificar el listado original
     *
     * @return listado ordenado
     */
    private static List<Persona> personasPorApellidos() {
        List<Persona> personasPorApellidos = new ArrayList<>(personas);
        personasPorApellidos.sort(new ComparadorApellidos());
        return personasPorApellidos;
    }

    /**
     * Devuelve un mapa en el que cada apellido que aparece al menos una vez en el
     * listado de personas, es clave del mapa, y el valor el número de veces que
     * aparece (se cuentan tanto primeros como segundos apellidos)
     * (OPCIONAL: Devolver mapa ordenado de mayor a menor por los valores)
     *
     * @return mapa
     */
    private static Map<String, Integer> repeticionApellidos() {
        HashMap<String, Integer> repeticionApellidos = new HashMap<>();

        for (Persona p : personas) {
            String apellidos = p.getApellidos();
            String[] apelsSeparados = apellidos.split(" ");
            for (String apellido : apelsSeparados) {
                if (repeticionApellidos.containsKey(apellido)) {
                    int contador = repeticionApellidos.get(apellido);
                    repeticionApellidos.put(apellido, contador + 1);
                } else {
                    repeticionApellidos.put(apellido, 1);
                }
            }
        }
        Map<String, Integer> apellidosOrdenados = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return repeticionApellidos.get(o2).compareTo(repeticionApellidos.get(o1));
            }
        });
        apellidosOrdenados.putAll(repeticionApellidos);

        return repeticionApellidos;
    }

    /**
     * Muestra por pantalla el mapa recibido como parámetro con el siguiente
     * formato: Álvarez -> 5
     *
     * @param mapa
     */
    private static void mostrarMapaSimple(Map<String, Integer> mapa) {
        Iterator<Map.Entry<String, Integer>> it = mapa.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> siguiente = it.next();
            String apel = siguiente.getKey();
            int frecuencia = siguiente.getValue();
            System.out.println(apel + " -> " + frecuencia);
        }


        /*
         * for(String apel : mapa.keySet()){
         *              System.out.println(apel + " -> " + mapa.get(apel));
         *         }
         */


    }

    /**
     * Devuelve un mapa en el que las claves son rangos de edad por decenas y los
     * valores el listado de personas que están en ese rango de eda(18-19, 20-29,
     * 30-39...). Sólo aparecerán aquellos rangos en los que haya al menos una
     * persona.
     *
     * @return
     */
    private static Map<String, List<Persona>> personasPorRangoEdad() {
        Map<String, List<Persona>> personasPorRangoEdad = new HashMap<>();

        for (Persona p : personas) {
            int edad = p.getEdad();
            int limiteInferior;
            String rango;
            if (edad == 18 || edad == 19) {
                limiteInferior = 18;
                rango = limiteInferior + "-" + (limiteInferior + 1);
            } else {
                limiteInferior = (edad / 10) * 10;
                rango = limiteInferior + "-" + (limiteInferior + 9);
            }

            if (!personasPorRangoEdad.containsKey(rango)) {
                personasPorRangoEdad.put(rango, new ArrayList<>());
            }

            personasPorRangoEdad.get(rango).add(p);
        }

        return personasPorRangoEdad;
    }

    /**
     * Muestra por pantalla el mapa recibido como parámetro con el siguiente
     * formato: 18-19 -> [García Sánchez, Ana - Álvarez Castro, Luis] 20-29 ->
     * [García López, Luis - Suárez Rodríguez, Sara]
     *
     * @param mapa
     */
    private static void mostrarMapaConLista(Map<String, List<Persona>> mapa) {
        for (Map.Entry<String, List<Persona>> entrada : mapa.entrySet()) {
            String rango = entrada.getKey();
            List<Persona> nombres = entrada.getValue();

            System.out.print(rango + " -> ");
            mostrarPersonas(nombres);

        }
    }

    /**
     * Borra del listado las personas en el rango de edad especificado.
     *
     * @param min
     * @param max
     * @return número de personas borradas
     */
    private static int borrarPorEdad(int min, int max) {
        List<Persona> personasBorradas = new ArrayList<>();
        for (Persona p : personas) {
            if (p.getEdad() >= min && p.getEdad() <= max) {
                personasBorradas.add(p);
            }
        }
        return personasBorradas.size();
    }

}
