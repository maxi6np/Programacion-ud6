import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class Persona {
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = calcularEdad();
    }

    private int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        /*int anio = fechaActual.getYear();
        int mes = fechaActual.getMonthValue();
        int dia = fechaActual.getDayOfMonth();

        int difAnio = anio - fechaNacimiento.getYear();
        if (mes < fechaNacimiento.getMonthValue() ||
                (mes == fechaNacimiento.getMonthValue() && dia < fechaNacimiento.getDayOfMonth())) {
            difAnio--;
        }
        return difAnio;*/
        return (int) fechaNacimiento.until(fechaActual, ChronoUnit.YEARS);

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        Persona p = new Persona("maximo", LocalDate.of(2001,5,23));
        System.out.println(p);

        //Convertir string a localdate
        String fechaNacimiento = "01/01/1990";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Persona p2 = new Persona("miguel", LocalDate.parse(fechaNacimiento,formateador));
        System.out.println(p2);

        DateTimeFormatter formateador2 = DateTimeFormatter.ofPattern("dd-MM-yy");

        //2 manera
        DateTimeFormatter formateador21 = new DateTimeFormatterBuilder()
                .appendPattern("dd/MM/")
                .appendValueReduced(ChronoField.YEAR, 2, 2, 1900)
                .toFormatter();
        Persona p3 = new Persona("marcos", LocalDate.parse("03-07-99",formateador2));
        System.out.println(p3);

        DateTimeFormatter formateador3 = DateTimeFormatter.ofPattern("yyyy-MM-d");
        Persona p4 = new Persona("pelayo", LocalDate.parse("1949-07-2",formateador3));
        System.out.println(p4);
    }

}
