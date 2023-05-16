package Oscars.app;

import java.util.Objects;

public class Pelicula {
    private String nombre;
    private int anio;
    private int edadActriz;

    public Pelicula(String nombre, int anio, int edadActriz) {
        this.nombre = nombre;
        this.anio = anio;
        this.edadActriz = edadActriz;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public int getEdadActriz() {
        return edadActriz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return anio == pelicula.anio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, anio, edadActriz);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(", ").append(anio);
        return sb.toString();
    }
}
