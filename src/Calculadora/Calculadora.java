package Calculadora;

import java.io.IOException;
import java.util.Scanner;

public class Calculadora {
    public double primerOp;
    public double segundoOp;
    public char operacion;
    public double resultado;
    public Scanner sc = new Scanner(System.in);
    public boolean salir = false;
    public final String SALIR = "SALIR";

    public void salir() {
        System.out.println("Si quieres salir, escribe 'SALIR'. " +
                "Si quieres seguir, pulsa cualquier otra tecla:");
        String texto = sc.next();
        if (texto.equalsIgnoreCase(SALIR)) {
            salir = true;
        }
    }

    public void leerOperandos() throws IOException {
        boolean correcto = false;
        while (!correcto) {
            System.out.println("Inserte primer operando:");
            primerOp = sc.nextDouble();
            System.out.println("Inserte segundo operando:");
            segundoOp = sc.nextDouble();
            correcto = true;

        }
    }

    public void leerOperador() throws ExceptionOperadorInvalido {
        boolean correcto = false;
        while (!correcto) {
            System.out.println("Introduzca el operador de la operación(+ , - , / , * ):");
            operacion = sc.next().trim().charAt(0);
            if (operacion != '+' && operacion != '-' && operacion != '/' && operacion != '*') {
                throw new ExceptionOperadorInvalido("Operador incorrecto");
            }
            correcto = true;
        }

    }

    public void realizarOperacion() throws DivisionPorCeroException {
        switch (operacion) {
            case '+' -> resultado = primerOp + segundoOp;
            case '-' -> resultado = primerOp - segundoOp;
            case '*' -> resultado = primerOp * segundoOp;
            case '/' -> {
                if (segundoOp == 0) {
                    throw new DivisionPorCeroException("No se puede dividir por cero");
                } else {
                    resultado = primerOp / segundoOp;
                }
            }
        }
    }

    public void mostrarResultado() {
        System.out.println("Resultado: " + primerOp + " " + operacion + " " + segundoOp + " = " + resultado);
    }
}
