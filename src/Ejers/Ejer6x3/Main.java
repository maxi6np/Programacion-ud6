package Ejers.Ejer6x3;

public class Main {
    public static void main(String[] args) {
        try{
            throw new ClasePropiaException("Ha habido un error en la línea de coca");
        } catch (ClasePropiaException e) {
            System.out.println(e.getMensaje());
        }
    }
}
