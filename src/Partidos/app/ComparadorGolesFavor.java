package Partidos.app;

import java.util.Comparator;

public class ComparadorGolesFavor implements Comparator<Equipo> {
    @Override
    public int compare(Equipo o1, Equipo o2) {
        int resultado = 0;
        if (o1 != null && o2 != null){
            resultado = o2.getGolesFavor() - o1.getGolesFavor();
            if (resultado == 0){
                resultado = o1.compareTo(o2);
            }
        }
        return resultado;
    }

}
