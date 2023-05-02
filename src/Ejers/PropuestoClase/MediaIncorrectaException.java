package Ejers.PropuestoClase;

public class MediaIncorrectaException extends Exception {
    String mensaje;

    public MediaIncorrectaException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return "PropiaException:" + mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
