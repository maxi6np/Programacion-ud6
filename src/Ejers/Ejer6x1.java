package Ejers;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejer6x1 {
    public static void main(String[] args) {
        try {
            int a = 4;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.err.println("No se puede dividir entre 0");
        }

        try {
            int[] array = new int[5];
            array[5] = 1;
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("El índice seleccionado esta fuera de los límites del array");
        }

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce un número entero:");
            int n = sc.nextInt();
            System.out.println("Número introducido: " + n);
        } catch (InputMismatchException e) {
            System.err.println("No se admiten decimales");

        }
    }
}