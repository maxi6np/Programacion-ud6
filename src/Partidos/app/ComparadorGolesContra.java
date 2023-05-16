package Partidos.app;

import java.util.Comparator;

public class ComparadorGolesContra implements Comparator<Equipo> {
    @Override
    public int compare(Equipo o1, Equipo o2) {
        int resultado = 0;
        if (o1 != null && o2 != null){
            resultado = o2.getGolesContra() - o1.getGolesContra();
            if (resultado == 0){
                resultado = o1.compareTo(o2);
            }
        }
        return resultado;
    }
}
