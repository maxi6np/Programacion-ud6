package Partidos.app;

import java.util.*;

public class Liga {
    public Set<Partido> partidos;
    public Set<Equipo> equipos;

    public Liga() {
        partidos = new HashSet<>();
        equipos = new TreeSet<>();
    }

    public void addPartido(Partido partido) {
        partidos.add(partido);
    }

    public void resultado() {
        for (Partido partido : partidos) {
            int puntosLocal = 0;
            int puntosVisitante = 0;

            if (partido.getGolesLocal() > partido.getGolesVisitante()) {
                puntosLocal = 3;
            } else if (partido.getGolesVisitante() > partido.getGolesLocal()) {
                puntosVisitante = 3;
            } else {
                puntosVisitante = 1;
                puntosLocal = 1;
            }

            actualizarEstadisticas(partido.getLocal(), partido.getGolesLocal(),
                    partido.getGolesVisitante(), puntosLocal);
            actualizarEstadisticas(partido.getVisitante(), partido.getGolesVisitante(),
                    partido.getGolesLocal(), puntosVisitante);
        }
    }

    private void actualizarEstadisticas(String nombre, int golesFavor, int golesContra, int puntos) {
        Equipo equipo = buscarEquipo(nombre);
        if (equipo != null) {
            equipo.setGolesFavor(golesFavor);
            equipo.setGolesContra(golesContra);
            equipo.setPuntos(puntos);
        } else {
            equipo = new Equipo(nombre, golesFavor, golesContra, puntos);
            equipos.add(equipo);
        }
    }

    private Equipo buscarEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equalsIgnoreCase(nombreEquipo)) {
                return equipo;
            }
        }
        return null;
    }

    public void imprimirLiga() {
        List<Equipo> equiposOrdenados = new ArrayList<>(equipos);
        Collections.sort(equiposOrdenados);
        System.out.printf("%-10s%-20s%-10s%-10s%-10s%n", "Posición", "Equipo", "Puntos", "GF", "GC");

        int contador = 0;
        for (Equipo equipo : equiposOrdenados) {
            System.out.printf("%-10s%-20s%-10s%-10s%-10s%n", ++contador, equipo.getNombre(),
                    equipo.getPuntos(), equipo.getGolesFavor(), equipo.getGolesContra());
        }
    }

    public void leerFichero() {
        Scanner entrada = null;
        try {
            entrada = new Scanner(this.getClass().getResourceAsStream("..\\partidos.txt"));
            while (entrada.hasNextLine()) {
                String linea = entrada.nextLine();
                String[] datosPartido = linea.split("::");
                String local = datosPartido[0].trim();
                String visitante = datosPartido[1].trim();
                int golesLocal = Integer.parseInt(datosPartido[2].trim());
                int golesVisitante = Integer.parseInt(datosPartido[3].trim());

                Partido partido = new Partido(local, visitante, golesLocal, golesVisitante);
                this.addPartido(partido);
            }

        } finally {
            try {
                entrada.close();
            } catch (NullPointerException e) {
                System.out.println("Error en IO , no se ha creado el fichero");
            }
        }
    }
}
