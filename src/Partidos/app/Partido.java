package Partidos.app;

import java.util.Objects;

public class Partido {
    public String local;
    public String visitante;
    public int golesLocal;
    public int golesVisitante;

    public Partido(String local, String visitante, int golesLocal, int golesVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partido partido)) return false;
        return Objects.equals(local, partido.local) && Objects.equals(visitante, partido.visitante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(local, visitante, golesLocal, golesVisitante);
    }
}
