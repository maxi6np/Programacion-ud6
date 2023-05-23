package Oscars.app;

import java.io.*;
import java.util.*;

public class Oscars {
    private Map<Actriz, Integer> oscarActriz;
    private Map<Actriz, Set<Pelicula>> peliculasActriz;

    public Oscars() {
        oscarActriz = new HashMap<>();
        peliculasActriz = new HashMap<>();
    }

    private void anadirOscarActriz(Actriz actriz) {

        if (!oscarActriz.containsKey(actriz)) {
            oscarActriz.put(actriz, 1);
        } else {
            int veces = oscarActriz.get(actriz);
            oscarActriz.put(actriz, veces + 1);
        }
    }

    private void anadirPeliculasActriz(Actriz actriz, Pelicula pelicula) {

        if (!peliculasActriz.containsKey(actriz)) {
            Set<Pelicula> peliculas = new HashSet<>();
            peliculas.add(pelicula);
            peliculasActriz.put(actriz, peliculas);
        } else {
            Set<Pelicula> peliculas = peliculasActriz.get(actriz);
            peliculas.add(pelicula);
            peliculasActriz.put(actriz, peliculas);
        }
    }

    public static Map<Actriz, Integer> ordenarPorValor(Map<Actriz, Integer> mapa) {
        List<Map.Entry<Actriz, Integer>> lista = new LinkedList<>(mapa.entrySet());

        lista.sort(new Comparator<Map.Entry<Actriz, Integer>>() {
            @Override
            public int compare(Map.Entry<Actriz, Integer> o1, Map.Entry<Actriz, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<Actriz, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<Actriz, Integer> entrada : lista) {
            mapaOrdenado.put(entrada.getKey(), entrada.getValue());
        }

        return mapaOrdenado;
    }


    public void mostrarActrices() {
        Map<Actriz, Integer> mapaOrdenado = ordenarPorValor(oscarActriz);
        for (Actriz actriz : mapaOrdenado.keySet()) {
            System.out.println(actriz.toString() + mapaOrdenado.get(actriz) + " Oscars");
            for (Pelicula pelicula : peliculasActriz.get(actriz)) {
                System.out.println("\t - " + pelicula.toString());
            }
        }
    }

    public Map<Actriz, Set<Pelicula>> buscarActricesYOscarsPorEdadMayorQue(Map<Actriz, Set<Pelicula>> mapa, int edad) {

        Map<Actriz, Set<Pelicula>> map = new HashMap<>();
        for (Actriz actriz : mapa.keySet()) {
            for (Pelicula pelicula : mapa.get(actriz)) {
                if (pelicula.getEdadActriz() >= edad) {
                    Set<Pelicula> p = new HashSet<>();
                    p.add(pelicula);
                    map.put(actriz, p);
                }
            }
        }
        return map;
    }

    public void peliculasPorPalabra(String texto) {
        System.out.println("Películas que contienen la cadena \"" + texto + "\":");

        for (Actriz actriz : peliculasActriz.keySet()) {
            for (Pelicula pelicula : peliculasActriz.get(actriz)) {
                if (pelicula.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                    System.out.println("- " + pelicula + ". " + actriz + " (" + pelicula.getAnio() + ")");
                }
            }
        }
    }

    public List<String> actricesSegunEdadConPelicula(int edad) {
        List<Pelicula> listaIntermedia = new ArrayList<>();
        List<String> resultado = new ArrayList<>();

        for (Actriz actriz : peliculasActriz.keySet()) {
            for (Pelicula pelicula : peliculasActriz.get(actriz)) {
                if (pelicula.getEdadActriz() == edad) {
                    listaIntermedia.add(pelicula);
                }
            }
        }
        listaIntermedia.sort(new ComparadorPeliculasEdad());

        for (Pelicula peli : listaIntermedia) {
            for (Actriz actriz : peliculasActriz.keySet()) {
                for (Pelicula pelicula : peliculasActriz.get(actriz)) {
                    if (peli.equals(pelicula)) {
                        String linea = actriz + ";" + peli.getNombre();
                        resultado.add(linea);
                    }
                }
            }
        }
        return resultado;
    }


    public void leerFichero(String nombre) {
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader(new FileReader(nombre));
            entrada.readLine(); //salta la primera linea
            String linea = entrada.readLine();

            while (linea != null) {
                String[] datosOscar = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                int anio = Integer.parseInt(datosOscar[1].trim());
                int edad = Integer.parseInt(datosOscar[2].trim());
                String actriz = datosOscar[3].trim().replaceAll("\"", "");
                String pelicula = datosOscar[4].trim().replaceAll("\"", "");


                this.anadirOscarActriz(new Actriz(actriz));
                this.anadirPeliculasActriz(new Actriz(actriz), new Pelicula(pelicula, anio, edad));
                linea = entrada.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error al leer " + nombre);

        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (NullPointerException | IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void cargarFichero(String nombre) {
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(nombre)));
            salida.println("<html>");
            salida.println("<title>Clasificacion de la liga</title>");
            salida.println("<body>");
            salida.println("<h2 style=\"font-size: 20px;\">Actrices que ganaron un Oscar con más de 65 años</h2>");

            Map<Actriz, Set<Pelicula>> mapa = buscarActricesYOscarsPorEdadMayorQue(peliculasActriz,65);
            for (Actriz actriz : mapa.keySet()) {
                salida.println("<ul>");
                salida.println("<li>" + actriz + "</li>");
                for (Pelicula pelicula : mapa.get(actriz)) {
                    salida.println("<ol>");
                    salida.println("<li>" + pelicula.getEdadActriz() + " años, " + pelicula + "</li>");
                    salida.println("</ol>");
                }
                salida.println("</ul>");
            }

            salida.println("</body>");
            salida.println("</html>");

        } catch (IOException e) {
            System.out.println("Error al crear el fichero " + nombre);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void cargarCSV(String nombre) {
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(nombre)));
            List<String> lista = actricesSegunEdadConPelicula(33);
            for (String linea : lista) {
                salida.println(linea);
            }

        } catch (IOException e) {
            System.out.println("Error al crear el fichero " + nombre);
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (NullPointerException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
