package Calculadora;

import java.io.IOException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args){
        menu();
    }
    public static void menu(){
        Calculadora c = new Calculadora();
            while (!c.salir) {
                try {
                    c.leerOperandos();
                    c.leerOperador();
                    c.realizarOperacion();
                    c.mostrarResultado();
                    c.salir();

                } catch (DivisionPorCeroException e) {
                    System.err.println(e.getMensaje());
                    menu();
                } catch (ExceptionOperadorInvalido e) {
                    System.err.println(e.getMensaje());
                    menu();
                } catch (IOException | InputMismatchException e) {
                    System.err.println("ERROR! Uno de los operandos es inválido");
                    menu();
                }

        }
    }
}
