package Ejers.PropuestoClase;

public class Main {
    public static void main(String[] args) {

        try {
            PropuestoClase pc = new PropuestoClase();
            pc.calcularMedia();
        }catch (MediaIncorrectaException e){
            System.err.println(e.getMensaje());
        }
    }
}
