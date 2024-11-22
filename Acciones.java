import java.util.*;

public class Acciones {

    public static Scanner tc = new Scanner(System.in);
    public static Acciones acciones = new Acciones();

    public static void main(String[] args) {

        System.out.println("---BIENVENIDO AL SISTEMA---");
        System.out.println(
                "¿Que desea hacer? \n1.Sumar filas. \n2.Sumar columnas. \n3.Multiplicar matrices. \nCualquer num para salir.");
        int opt = tc.nextInt();
        int fil = acciones.dim();
        int col = acciones.dim();
        int[][] matrizA = acciones.crearMatriz(fil, col);

        switch (opt) {
            case 1:

                Stack<Double> pila = acciones.sumaFila(matrizA);

                int cont = pila.size();

                for (int i = 0; i < cont; i++) {
                    System.out.println("El promedio de la fila #" + (i + 1) + ": " + pila.peek());
                    pila.pop();
                }
                break;
            case 2:
                Stack<Double> pila2 = acciones.sumaColum(matrizA);

                int conta = pila2.size();

                for (int i = 0; i < conta; i++) {
                    System.out.println("La raiz de la columna #" + (i + 1) + ": " + pila2.peek());
                    pila2.pop();
                }
                break;
            case 3:
                int[][] matrizB = acciones.crearMatriz(fil, col);

                Stack<Integer> pilamulti = acciones.multiMatrices(matrizA, matrizB);

                int num = pilamulti.size();
                int ban = num;

                System.out.println("El producto de cada uno de los " + num
                        + " numeros que hay en la \nmatriz A con su correspondiente en la matriz B es");

                for (int i = 0; i < num; i++) {
                    System.out.println("La multiplicación del valor #" + (ban) + " es: " + pilamulti.peek());
                    System.out.println("-----------------------------------------------");
                    pilamulti.pop();
                    ban--;
                }

                break;
            default:
                break;
        }

        System.out.println("---GRACIAS POR USAR NUESTRO SISTEMA---\n\t\t:)");

    }

    public int dim() {
        System.out.println("¿Cual dimencion desea que tenga la matriz?: ");
        return tc.nextInt();
    }

    public int[][] crearMatriz(int fil, int col) {

        int[][] matriz = new int[fil][col];

        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                matriz[i][j] = (int) (Math.random() * 10 + 1);
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------");
        return matriz;
    }

    public Stack<Double> sumaFila(int[][] matriz) {

        double sum = 0;
        Stack<Double> pila = new Stack<>();
        Stack<Double> pilaAux = new Stack<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                sum = sum + matriz[i][j];
            }
            pila.add(sum / matriz[0].length);
            sum = 0;
        }

        for (int k = 0; k < matriz.length; k++) {
            pilaAux.push(pila.peek());
            pila.pop();
        }

        return pilaAux;
    }

    public Stack<Double> sumaColum(int[][] matriz) {

        double sum = 0;
        Stack<Double> pila = new Stack<>();
        Stack<Double> pilaAux = new Stack<>();

        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                sum = sum + matriz[j][i];
            }
            pila.add(Math.pow(sum, 1.0 / 2.0));
            sum = 0;
        }

        for (int i = 0; i < matriz[0].length; i++) {
            pilaAux.push(pila.peek());
            pila.pop();
        }

        return pilaAux;
    }

    public Stack<Integer> multiMatrices(int[][] matrizA, int[][] matrizB) {

        Stack<Integer> product = new Stack<>();

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                product.push(matrizA[i][j] * matrizB[i][j]);
            }
        }

        System.out.println("------------------------------------");

        return product;
    }

}