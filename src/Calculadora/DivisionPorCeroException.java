package Calculadora;

public class DivisionPorCeroException extends RuntimeException{
    public String mensaje;
    public DivisionPorCeroException(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return "DivisionPorCeroException: " + mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
