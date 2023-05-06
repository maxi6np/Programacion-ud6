package Calculadora;

public class ExceptionOperadorInvalido extends Exception{
    public String mensaje;
    public ExceptionOperadorInvalido(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return "ExceptionOperadorInvalido: " + mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
