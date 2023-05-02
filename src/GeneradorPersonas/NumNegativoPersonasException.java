package GeneradorPersonas;

public class NumNegativoPersonasException extends Exception{
    String mensaje;
    int numero;

    public NumNegativoPersonasException(String mensaje, int numero) {
        super();
        this.mensaje = mensaje;
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
