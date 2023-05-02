package Ejers.PropuestoClase;

import java.util.Scanner;

//Pide al usuario ingresar 10 números separados por espacio, calcula el promedio de esos números y lo muestra en pantalla
//En caso de que el usuario ingrese una cantidad de números insuficiente para calcular el promedio, se lanza una excepcion NumberFormatException y mostrará un mensaje de error
//Si el numero de cifras es correcto, se calculará la media con un método estatico calcularMedia()
//Si la media da un resultado negativo, se lanzara una excepcion propia que se manejara en la clase main.
public class PropuestoClase {
    public void calcularMedia() throws MediaIncorrectaException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa 10 números separados por espacio");
        String numeros = sc.nextLine();
        if (numeros.length() <= 9){
            System.err.println("Introduzca 10 cifras o más");
            throw new NumberFormatException();
        }
        String[] numArray = numeros.split(" ");
        double suma = 0;

        for (int i = 0; i < numArray.length; i++) {
            suma += Double.parseDouble(numArray[i]);
        }
        double promedio = suma / numArray.length;
        if (promedio <= 0){
            throw new MediaIncorrectaException("La media es negativa o 0");
        }
        System.out.println("La media es: " + promedio);
    }
}
