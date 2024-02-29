package metodo_biseccion_5;

import java.util.Scanner;

/**
 *
 * @author Alan
 */
public class Metodo_Biseccion_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" EJECICIO 5 METODO DE BISECCION ");
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el límite inferior: ");
        double a = scanner.nextDouble();

        System.out.print("Ingrese el límite superior: ");
        double b = scanner.nextDouble();

        // Pedir al usuario que ingrese el número máximo de iteraciones
        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = scanner.nextInt();

        // Pedir al usuario que ingrese el valor de tolerancia (error aceptable)
        System.out.print("Ingrese el valor de tolerancia: ");
        // Leer el valor de tolerancia (error aceptable) desde el usuario
        double tol = scanner.nextDouble();

        // Encontrar la raíz de la función usando el método de bisección
        double root = bisectionMethod(a, b, maxIter, tol);

        // Imprimir el resultado 
        System.out.printf("La raíz de la ecuación es: %.5f%n", root);
        /*
         Esta parte %.5f%n sirve para dejar el numero decimal con 5 digitos despues del punto decimal
        */
    }

    // Definir el método de bisección
    public static double bisectionMethod(double a, double b, int maxIter, double tol) {
        // Verificar si la función cambia de signo en el intervalo
        if ((func(a) * func(b)) > 0) {
            System.out.println("El método no puede encontrar una raíz en el intervalo.");
            return -1;
        }

        double c;
        // Iterar hasta que se alcance el número máximo de iteraciones
        for (int i = 0; i < maxIter; i++) {
            // Calcular el punto medio del intervalo
            c = (a + b) / 2;
            // Verificar si el punto medio está dentro de la tolerancia
            if (Math.abs(func(c)) < tol) {
                // Devolver el punto medio como la raíz
                return c;
            }
            // Actualizar el intervalo
            if (func(a) * func(c) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        // Devolver el punto medio del intervalo final como la raíz
        return (a + b) / 2;
    }

    // Definir la función para encontrar la raíz de
    public static double func(double x) {
        return Math.pow(x, 10) -1;
    }
    
}
