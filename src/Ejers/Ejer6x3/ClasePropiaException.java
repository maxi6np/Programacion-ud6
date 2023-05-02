package Ejers.Ejer6x3;

public class ClasePropiaException extends Exception{
    String mensaje;

    public ClasePropiaException(String mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
