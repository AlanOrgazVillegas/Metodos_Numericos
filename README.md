SOBRE MI Y EL REPOSITORIO

Mi nombre es Alan Orgaz Villegas y soy estudiante de cuarto semestre de la carrera de ingeniería en sistemas computacionales en ITESA.

El presente repositorio abarca tres metodos numericos: Metodo de biseccion, metodo de regla falsa, y metodo de secante.

Cada carpeta tiene 5 ejericios con diferentes funciones, en los programas se piden los limtes, la cantidad de intervalos, la tolerancia o el error aceptable y Por 
último se muetsra la raíz.

Dentro de cada ejemplo viene la descripoción y la solución de cada ejemplo.
*****************************************************************************************************************************************************************
SOBRE LA MATERIA

Competencia de la Asignatura

         Aplica los métodos numéricos para resolver problemas científicos y de ingeniería utilizando la computadora.

Competencia del TEMA

  Aplica los métodos numéricos con el objeto de solucionar ecuaciones mediante los métodos de intervalo e interpolación apoyada de un lenguaje de programación.  

TEMARIO 
2.1 Métodos de intervalo. 
 2.2 Método de bisección. 
 2.3 Método de aproximaciones sucesivas. 
 2.4 Métodos de interpolación. 
 2.5 Aplicaciones.

****************************************************************************************************************************************************

Metodos del rpositorio:

         - Métedo de bisección
         
         - Método de regla falsa
         
         - Método de la secante



*************************************************************************************************************************************************************

-------------Metodo de biseccion------------

![Captura de pantalla (392)](https://github.com/AlanOrgazVillegas/Metodos_Numericos/assets/147757830/6f33161d-5b7b-4b4f-9b91-01a7fec93c11)

Descripcion

El metodo de biseccion, conocido tambien como de corte binario, de particion deintervalos o de Bolzano, es un tipo de búsqueda incremental en el que el intervalo se divide siempre a la mitad. Si la funcion cambia de signo sobre un intervalo, se evalua el valor de la funcion en el punto medio. La posición de la raíz se determina situandola en el punto medio del subintervalo, dentro del cual ocurre un cambio de signo. El proceso se repite hasta obtener una mejor aproximacion.

Algoritmo

Paso 1: Elija valores iniciales inferior, xl, y superior, xu, que encierren la raíz, de formatal que la función cambie de signo en el intervalo. Esto se verifica comprobando
que f(xl) f(xu) < 0.
Paso 2: Una aproximación de la raíz xr se determina mediante:
Xr = (Xl + Xu) / 2
Paso 3: Realice las siguientes evaluaciones para determinar en qué subintervalo está la raíz: a) Si f(xl)f(xr) < 0, entonces la raíz se encuentra dentro del subintervalo inferior
o izquierdo. Por lo tanto, haga xu = xr y vuelva al paso 2. b) Si f(xl)f(xr) > 0, entonces la raíz se encuentra dentro del subintervalo superioro derecho. Por lo tanto, haga xl = xr y vuelva al paso 2. c) Si f(xl)f(xr) = 0, la raíz es igual a xr; termina el cálculo.

-----Un ejemplo en código-------

Función: x^3+4x^2-10    Limites: A:1 B:2    Error: 0.0001    Iteraciones: 6

package metodo_biseccion;
import java.util.Scanner;
/**
 *
 * @author Alan
 */
public class Metodo_Biseccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" EJECICIO 1 METODO DE BISECCION ");
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
        // repetir hasta que se alcance el número máximo de iteraciones
        for (int i = 0; i < maxIter; i++) {
            // Calcular el punto medio del intervalo
            c = (a + b) / 2;
            // Verificar si el punto medio está dentro de la tolerancia (error aceptable)
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
        return Math.pow(x, 3) + 4 * Math.pow(x, 2) - 10;
    }
    
}

Raíz: 1.36719

--------Comprobación por Geogebra------------

![Captura de pantalla (403)](https://github.com/AlanOrgazVillegas/Metodos_Numericos/assets/147757830/d7608b2a-b9c1-4019-a661-369bf66bb745)



---------------Metodo de la regla falsa--------------------

![Captura de pantalla (393)](https://github.com/AlanOrgazVillegas/Metodos_Numericos/assets/147757830/c6f05713-2b6e-476e-b9c7-f30dfadcec78)

Descripcion
![Captura de pantalla (403)](https://github.com/AlanOrgazVillegas/Metodos_Numericos/assets/147757830/93f0ff17-7503-4dfb-a1ea-96147b91eb32)

Aun cuando la bisección es una técnica perfectamente válida para determinar raíces, su método de aproximación por “fuerza bruta” es relativamente ineficiente. La falsa posición es una alternativa basada en una visualización gráfica.

Algoritmo

1. Seleccionar los valores iniciales de a y b y evaluar en este intervalo, de manera que la funcion cambie de signo, establecer una tolerancia de error.
2. La primera aproximacion se calcula con la siguiente ecuacion: Xr = b - f(b)(a-b) / f(a)-f(b)
3. Relaizar las siguientes evaluaciones:
- Si f(a) * f(Xr) = 0 : se terminan los calculos
- Si f(a) * f(Xr) > 0 : la raiz se encuentra entre Xr y b. Hacer a = Xr.
- Si f(a) * f(Xr) < 0 : la raiz se encuentra entre Xr y a. Hacer b = Xr.
4. Calcular el nuevo Xr.
5. Calcular el error aproximado para ver si se cumple el criterio establecido.

----------Metodo de secante------------
![Captura de pantalla (394)](https://github.com/AlanOrgazVillegas/Metodos_Numericos/assets/147757830/239dc843-299f-4c81-bb9e-cfccb03b2de4)

Descripcion

El metodo de la secante se puede pensar como una simplificacion del metodo de Newton-Raphson. En lugar de tomar la derivada de la funcion cuya raız se quiere encontrar, se aproxima por una recta secante (de ahı el nombre) a la curva, cuya pendiente es aproximadamente igual a la derivada en el punto inicial. 

Algoritmo

El método se basa en obtener la ecuación de la recta que pasa por los puntos (xn−1, f(xn−1)) y (xn, f(xn)). A dicha recta se le llama secante por cortar la gráfica de la función. En forma punto-pendiente, esta línea tiene la ecuación mostrada anteriormente. Posteriormente se escoge como siguiente elemento de la relación de recurrencia, xn+1, la intersección de la recta secante con el eje de abscisas obteniendo la fórmula, y un nuevo valor. Seguimos este proceso, hasta llegar a un nivel suficientemente alto de precisión (una diferencia lo suficientemente pequeñas entre xn y xn-1).


 
