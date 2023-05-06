package Calculadora;

public class DivisionPorCeroException extends Exception{
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
