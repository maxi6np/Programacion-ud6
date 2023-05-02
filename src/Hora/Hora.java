package Hora;

import java.io.IOException;

public class Hora {
    public int hora;
    public int minuto;
    public int segundo;

    public Hora(int h, int m, int s) throws HoraException {
        if (h < 0 || h > 23) {
            throw new HoraException("Hora no válida: " + h);
        } else if (m < 0 || m > 59) {
            throw new HoraException("Minutos no válidos: " + m);
        } else if (s < 0 || s > 59) {
            throw new HoraException("Segundos no válidos: " + s);
        } else {
            this.hora = h;
            this.minuto = m;
            this.segundo = s;
        }
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
        sb.append(String.format("%02d", hora));
        sb.append(":").append(String.format("%02d", minuto));
        sb.append(":").append(String.format("%02d", segundo));
        return sb.toString();
    }
}
