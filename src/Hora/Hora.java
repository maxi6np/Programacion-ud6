package Hora;

public class Hora {
    public int hora;
    public int minuto;
    public int segundo;

    public Hora(int h, int m, int s) throws IllegalArgumentException{
        if (h < 0 || h > 23){
            throw new IllegalArgumentException("Hora no válida: " + h);
        }
        if (m < 0 || m > 59){
            throw new IllegalArgumentException("Minutos no válidos: " + m);
        }
        if (s < 0 || s > 59){
            throw new IllegalArgumentException("Segundos no válidos: " + s);
        }
        this.hora = h;
        this.minuto = m;
        this.segundo = s;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(hora).append(":").append(minuto).append(":").append(segundo);
        return sb.toString();
    }
}
