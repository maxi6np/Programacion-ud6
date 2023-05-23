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
        return "NumNegativoPersonasException: " + mensaje + " (" + numero + ")";
    }
}
