package Hora;

public class HoraException extends Exception {
    public String mensaje;

    public HoraException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("HoraException: ").append(mensaje);
        return sb.toString();
    }
}
