package Partidos.app;

public class Equipo implements Comparable<Equipo>{
    public String nombre;
    public int puntos;
    public int golesFavor;
    public int golesContra;

    public Equipo(String nombre, int golesFavor, int golesContra,int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getGolesFavor() {return golesFavor;}

    public int getGolesContra() {
        return golesContra;
    }

    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor += golesFavor;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra += golesContra;
    }

    @Override
    public int compareTo(Equipo o) {
        int resultado = o.puntos - this.puntos;
        if (resultado == 0) {
            resultado = this.nombre.compareTo(o.nombre);
        }
        return resultado;
    }
}
