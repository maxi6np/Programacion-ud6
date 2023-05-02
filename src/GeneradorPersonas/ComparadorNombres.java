package GeneradorPersonas;

import java.util.Comparator;

public class ComparadorNombres implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1 != null && o2 != null){
            return o1.getNombre().compareTo(o2.getNombre());
        }
        return 0;
    }
}
