package GeneradorPersonas;

import java.util.Comparator;

public class  ComparadorApellidos implements Comparator<Persona> {
    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1 != null && o2 != null) {
            return o1.getApellidos().compareTo(o2.getApellidos());
        }
        return 0;
    }
}
