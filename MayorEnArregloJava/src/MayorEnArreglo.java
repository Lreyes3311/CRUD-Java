
/**
 *
 * @author lreye
 */
public class MayorEnArreglo {
    public static void main(String[] args) {
        //Arreglo
        int [] arreglo = {10, 5, 8, 20, 15, 85};
        
        //Llamada a la funciona para encontrar el numero mayor
        int mayor = encontrarMayor(arreglo);
        
        //Imprimir el resultado
        System.out.println("El numero mayor en el arreglo es: " + mayor);
    }
    
    //Funcion para encontrar el numero mayor en un arreglo
    private static int encontrarMayor(int[]arreglo){
        
        //Supongamos que el primer numero es el mayor
        int mayor = arreglo[0];
        
        //Iteramos sobre los elementos del arreglo
        for (int i = 0; i < arreglo.length; i++) {
            //Si encontramos un numero mayor, lo actualizamos
            if (arreglo[i] > mayor) {
                mayor = arreglo[i];
            }            
        }
        return mayor;
    }
}
