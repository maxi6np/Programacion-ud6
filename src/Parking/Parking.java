package Parking;

import java.util.ArrayList;
import java.util.Collections;

public class Parking {
    private final String nombre;
    private final ArrayList<String> matriculas;

    public Parking(String nombre, int plazas) {
        this.nombre = nombre;
        //Inicializamos todas las plazas a null
        matriculas = new ArrayList<>(Collections.nCopies(plazas, null));
    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int plaza) throws ParkingException {
        //Si el usuario pone una plaza mayor o menor a las del parking
        if (plaza >= matriculas.size() || plaza < 0) {
            throw new ParkingException("Plaza inexistente", matricula);
        }

        //Si la matricula no existe o tiene menos de 4 caracteres,lanza error
        if (matricula == null || matricula.length() < 4) {
            throw new ParkingException("Matrícula incorrecta", matricula);
        }

        //Si la plaza ya está ocupada,lanza error
        if (matriculas.get(plaza) != null) {
            throw new ParkingException("Plaza ocupada", matricula);
        }

        //Si la matricula ya existe en el parking,lanza error
        if (matriculas.contains(matricula)) {
            throw new ParkingException("Matrícula repetida", matricula);
        }

        //Si no salta ningún error se añade la matrícula al parking
        matriculas.set(plaza, matricula);
    }

    public int salida(String matricula) throws ParkingException {
        //Si la matricula no esta en el parking,lanza error
        if (!(matriculas.contains(matricula))) {
            throw new ParkingException("Matrícula no existente", matricula);
        }
        //Guardamos el sitio del coche en una variable
        int plaza = matriculas.indexOf(matricula);

        //Al salir del parking, el sitio queda libre
        matriculas.set(plaza, null);
        return plaza;
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasLibres() {
        //Cuantas veces se repite "null" en el ArrayList "matriculas"
        return Collections.frequency(matriculas, null);
    }

    public int getPlazasOcupadas() {
        return getPlazasTotales() - getPlazasLibres();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("\nParking ").append(getNombre());
        sb.append("\n-----------------------------");
        for (int i = 0; i < matriculas.size(); i++) {
            sb.append("\nPlaza ").append(i).append(": ");
            if (matriculas.get(i) == null) {
                sb.append("vacío");
            } else {
                sb.append(matriculas.get(i));
            }
        }

        return sb.toString();
    }
}
