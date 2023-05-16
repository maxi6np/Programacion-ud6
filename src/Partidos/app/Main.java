package Partidos.app;

public class Main {
    public static void main(String[] args) {
        Liga liga = new Liga();
        liga.leerFichero();
        liga.resultado();
        liga.imprimirLiga();
        liga.ficheroClasificacionCompleta("liga.html");
        liga.ficheroGolesFavor("golesFavor.html");
        liga.ficheroGolesContra("golesContra.html");
    }
}
