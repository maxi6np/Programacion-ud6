package Oscars.app;

import java.util.Objects;

public class Actriz {
    private String nombre;

    public Actriz(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actriz actriz = (Actriz) o;
        return Objects.equals(nombre, actriz.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
