package Hora;

import java.io.IOException;

public class DemoHora {
    public static void demo() {
        try {
            //Hora h1 = new Hora(-4, 59, 59);
            //Hora h2 = new Hora(23, 59, -1);
            Hora h3 = new Hora(23, 600, 59);
            Hora h4 = new Hora(23, 4, 59);

            //System.out.println(h1);
            //System.out.println(h2);
            System.out.println(h3);
            System.out.println(h4);

        } catch (IllegalArgumentException e) {
            System.err.println("Error(IllegalArgumentException)! " + e.getMessage());
        } catch (HoraException e){
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        demo();
    }
}
