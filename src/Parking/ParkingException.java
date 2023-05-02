package Parking;

public class ParkingException extends Exception {

    private final String matricula;
    private final String mensaje;

    public ParkingException(String mensaje, String matricula) {
        this.mensaje = mensaje;
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMensaje() {
        return mensaje;
    }
}
