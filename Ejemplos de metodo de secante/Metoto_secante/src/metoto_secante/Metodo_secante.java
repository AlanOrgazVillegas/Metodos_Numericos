package metoto_secante;

import java.util.Scanner;

/**
 *
 * @author Alan
 */
public class Metodo_secante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(" EJEMPLO 1 METODO DE SECANTE ");
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese Xi: ");
        double x0 = scanner.nextDouble(); // Leer Xi "a"
        System.out.print("Ingrese Xi-1: ");
        double x1 = scanner.nextDouble(); // Leer Xi-1 "b"
        System.out.print("Ingrese el número máximo de iteraciones: ");
        int maxIter = scanner.nextInt(); // Leer el número máximo de iteraciones 
        System.out.print("Ingrese el valor de tolerancia: ");
        double tol = scanner.nextDouble(); // Leer el valor de tolerancia 

        double root = metodoSecante(x0, x1, maxIter, tol); // Llamar al método metodoSecante 

        System.out.printf("La raíz de la ecuación es: %.5f%n", root); // Imprimir el resultado del método metodoSecante con 5 dígitos de precisión después del punto decimal
    }

    public static double metodoSecante(double x0, double x1, int maxIter, double tol) {
        if (func(x0) * func(x1) == 0) {
            System.out.println("El método no puede encontrar una raíz."); // Verificar 
            return -1;
        }

        double x2 = 0;
        for (int i = 0; i < maxIter; i++) {
            x2 = x1 - (func(x1) * (x1 - x0) / (func(x1) - func(x0))); // Calcular la siguiente aproximacion usando el método de la secante
            if (Math.abs(x1 - x2) < tol) {
                return x2; // Si el cambio en las aproximaciones es menor que el valor de tolerancia, devolver la aproximacion actual como la raíz
            }
            x0 = x1; // Actualizar el valor de x0
            x1 = x2; // Actualizar el valor de x1
        }
        return x2; // Si se alcanza el número máximo de iteraciones sin encontrar una raíz con la tolerancia especificada, devolver la última aproximacion
    }

    public static double func(double x) {
        return Math.pow(x, 2) - 3 * x - 4; // Definir la función cuya raíz se desea encontrar
    }

}
