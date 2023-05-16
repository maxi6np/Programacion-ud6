package Partidos.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Liga {
    public Set<Partido> partidos;
    public Set<Equipo> equipos;

    public Liga() {
        partidos = new HashSet<>();
        equipos = new HashSet<>();
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

    public void ficheroClasificacionCompleta(String nombre) {
        FileWriter f = null;
        int contador = 0;
        try {
            f = new FileWriter(nombre);
            f.write("<html>");
            f.write("<title>Clasificacion de la liga</title>");
            f.write("<body>");
            f.write("<h2 style=\"font-size: 20px;\">Liga Santander</h2>");

            f.write("<table style=\"border= 1;\">");
            f.write("<tr>");
            f.write("<th>Posicion</th>");
            f.write("<th>Equipos</th>");
            f.write("<th>GF</th>");
            f.write("<th>GC</th>");
            f.write("</tr>");

            List<Equipo> equiposOrdenados = new ArrayList<>(equipos);
            Collections.sort(equiposOrdenados);
            for (Equipo equipo : equiposOrdenados) {
                f.write("<tr>");
                f.write("<td>" + (++contador) + "</td>");
                f.write("<td>" + equipo.getNombre() + "</td>");
                f.write("<td>" + equipo.getGolesFavor() + "</td>");
                f.write("<td>" + equipo.getGolesContra() + "</td>");
                f.write("</tr>");
            };

            f.write("</table>");
            f.write("</body>");
            f.write("</html>");
        } catch (IOException e) {
            System.out.println("Error al crear " + nombre);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar " + nombre);
                }
            }
        }
    }
    public void ficheroGolesFavor(String nombre) {
        FileWriter f = null;
        int contador = 0;
        try {
            f = new FileWriter(nombre);
            f.write("<html>");
            f.write("<title>Clasificacion de la liga</title>");
            f.write("<body>");
            f.write("<h2 style=\"font-size: 20px;\">Liga Santander según GF</h2>");

            f.write("<table style=\"border= 1;\">");
            f.write("<tr style=\"color = darkred;\">");
            f.write("<th>Posicion</th>");
            f.write("<th>Equipos</th>");
            f.write("<th>GF</th>");
            f.write("</tr>");

            List<Equipo> equiposOrdenados = new ArrayList<>(equipos);
            equiposOrdenados.sort(new ComparadorGolesFavor());
            for (Equipo equipo : equiposOrdenados) {
                f.write("<tr style=\"color = lightgreen;\">");
                f.write("<td>" + (++contador) + "</td>");
                f.write("<td>" + equipo.getNombre() + "</td>");
                f.write("<td>" + equipo.getGolesFavor() + "</td>");
                f.write("</tr>");
            };

            f.write("</table>");
            f.write("</body>");
            f.write("</html>");
        } catch (IOException e) {
            System.out.println("Error al crear " + nombre);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar " + nombre);
                }
            }
        }
    }
    public void ficheroGolesContra(String nombre) {
        FileWriter f = null;
        int contador = 0;
        try {
            f = new FileWriter(nombre);
            f.write("<html>");
            f.write("<title>Clasificacion de la liga</title>");
            f.write("<body>");
            f.write("<h2 style=\"font-size: 20px;\">Liga Santander segun GC</h2>");

            f.write("<table style=\"border= 1;\">");
            f.write("<tr>");
            f.write("<th>Posicion</th>");
            f.write("<th>Equipos</th>");
            f.write("<th>GC</th>");
            f.write("</tr>");

            List<Equipo> equiposOrdenados = new ArrayList<>(equipos);
            equiposOrdenados.sort(new ComparadorGolesContra());
            for (Equipo equipo : equiposOrdenados) {
                f.write("<tr>");
                f.write("<td>" + (++contador) + "</td>");
                f.write("<td>" + equipo.getNombre() + "</td>");
                f.write("<td>" + equipo.getGolesContra() + "</td>");
                f.write("</tr>");
            };

            f.write("</table>");
            f.write("</body>");
            f.write("</html>");
        } catch (IOException e) {
            System.out.println("Error al crear " + nombre);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar " + nombre);
                }
            }
        }
    }

}
