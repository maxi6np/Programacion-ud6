package Practica_examen.src.java;

public enum Categoria {

    A(0,0, 0),
   B(0,0, 0),
    C(0,0, 0);
    int salario;
    int vacaciones;
    int vacacionesDisfrutadas;

    Categoria(int salario, int vacaciones, int vacacionesDisfrutadas) {
        this.salario = salario;
        this.vacaciones = vacaciones;
        this.vacacionesDisfrutadas = vacacionesDisfrutadas;
    }


    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalario() {

        return salario;
    }

    public int getVacaciones() {
        return vacaciones;
    }

    public void setVacaciones(int vacaciones) {
        this.vacaciones = vacaciones;
    }

    public int getVacacionesDisfrutadas() {
        return vacacionesDisfrutadas;
    }

    public void setVacacionesDisfrutadas(int vacacionesDisfrutadas) {
        this.vacacionesDisfrutadas = vacacionesDisfrutadas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nSalario:").append(salario);
        sb.append("\nVacaciones: ").append(vacaciones);
        sb.append("\nVacaciones disfrutadas:").append(vacacionesDisfrutadas);
        sb.append("\nDías de vacaciones restantes: ").append(vacaciones - vacacionesDisfrutadas);
        return sb.toString();
    }
}
