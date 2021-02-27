import java.util.Scanner;

public class Criba {
    
    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            int dim = max + 1;
            boolean[] esPrimo = new boolean[dim];

            iniciaArray(dim, esPrimo);

            esPrimo[0] = esPrimo[1] = false;

            criba(dim, esPrimo);

            int cuenta = cuentaPrimos(dim, esPrimo);
            int[] primos = rellenarConPrimos(dim, esPrimo, cuenta);

            return primos;
        } else 
            return new int[0];
    }

    private static int[] rellenarConPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int cuentaPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    private static void criba(int dim, boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dim; j += i)
                    esPrimo[j] = false;
            }
        }
    }

    private static void iniciaArray(int dim, boolean[] esPrimo) {
        for (int i = 0; i < dim; i++)
            esPrimo[i] = true;
    }


    private static void muestraVectorPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }

    private static void muestraVectorInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        
        int dato = teclado.nextInt();
        int vector[] = new int[dato];

        teclado.close();
        
        System.out.println("\nVector inicial hasta :" + dato);
        muestraVectorInicial(vector);
       
        vector = generarPrimos(dato);
       
        System.out.println("\nVector de primos hasta:" + dato);
        muestraVectorPrimos(vector);
    }
}