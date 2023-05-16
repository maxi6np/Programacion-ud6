package Oscars.app;

public class Main {
    public static void main(String[] args) {
        Oscars oscar = new Oscars();
        oscar.leerFichero("src\\Oscars\\actrices.csv");
        //oscar.mostrarActrices();
        //oscar.cargarFichero("viejas.html");
        //oscar.peliculasPorPalabra("good");
        oscar.cargarCSV("actricesYPeliculasPorEdadConcreta.csv");
    }
}
