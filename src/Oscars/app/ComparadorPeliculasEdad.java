package Oscars.app;

import java.util.Comparator;

public class ComparadorPeliculasEdad implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula o1, Pelicula o2) {
        if (o1 != null && o2 != null){
            return o1.getNombre().compareTo(o2.getNombre());
        }
        return 0;
    }
}
