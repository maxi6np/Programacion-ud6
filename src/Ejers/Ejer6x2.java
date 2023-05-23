package Ejers;

public class Ejer6x2 {
    public static void main(String[] args) {
        String valor = null;


        try {
            for (int i = 0; i < valor.length(); i++) {
                System.out.println(valor.charAt(i));
            }
        }catch (NullPointerException e){
            System.out.println("El valor es nulo");
        }
    }
}
