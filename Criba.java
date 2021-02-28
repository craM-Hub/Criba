import java.util.Scanner;
/**
 * Este programa contiene una clase para generar todos los números primos de 1
 * hasta un número máximo especificado  por  el  usuario.
 *  
 * El algoritmo  es simple:  Dado  un  vector  de enteros empezando  en  2, se
 * tachan  todos  los  múltiplos de  2.  A  continuación,  se  encuentra  el  
 * siguiente entero no tachado y se tachan todos sus múltiplos.
 * 
 * El proceso se repite hasta que se pasa de la raíz cuadrada del valor máximo.
 * Todos los números que queden sin tachar son números primos.
 * 
 * @author craM-Hub
 * 
 */
public class Criba {

    /**
     * 
     * @param max   Número hasta el cual buscaremos números primos.
     * @return      Devuelve un array con los números primos encontrados
     * 
     */
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
        } else {
            return new int[0];
        }
    }

    
    /** 
     * Rellena un array con los primos encontrados
     * @param dim
     * @param esPrimo
     * @param cuenta
     * @return int[]
     */
    private static int[] rellenarConPrimos(int dim, boolean[] esPrimo, int cuenta) {
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < dim; i++) {
            if (esPrimo[i]){
                primos[j++] = i;
            }
        }
        return primos;
    }

    
    /** 
     * Cuenta los primos que hay en el array
     * @param dim
     * @param esPrimo
     * @return int
     */
    private static int cuentaPrimos(int dim, boolean[] esPrimo) {
        int cuenta = 0;
        for (int i = 0; i < dim; i++) {
            if (esPrimo[i]){
                cuenta++;
            }
        }
        return cuenta;
    }

    
    /** 
     * Criba los números, dejando en true los primos y cambiando a false los no primos.
     * @param dim
     * @param esPrimo
     */
    private static void criba(int dim, boolean[] esPrimo) {
        for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
            if (esPrimo[i]) {
                for (int j = 2 * i; j < dim; j += i){
                    esPrimo[j] = false;
                }
            }
        }
    }

    
    /** 
     * Inicia el array con el tamaño adecuado
     * @param dim
     * @param esPrimo
     */
    private static void iniciaArray(int dim, boolean[] esPrimo) {
        for (int i = 0; i < dim; i++){
            esPrimo[i] = true;
        }
    }


    
    /** 
     * Muestra en consola el vector con los números primos
     * @param vector
     */
    private static void muestraVectorPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0){
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }

    
    /** 
     * Muestra en consola el vector inicial
     * @param vector
     */
    private static void muestraVectorInicial(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0){
                System.out.println();
            }
            System.out.print(i + 1 + "\t");
        }
    }
    
    /** 
     * @param args
     */
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