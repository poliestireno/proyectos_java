// Archivo: Caracol.java
import java.util.Random;

public class Caracol {
    public static void main(String[] args) {
        // Verificamos que los parámetros son correctos
        if (args.length < 3) {
            System.out.println("Uso: java Caracol <letra> <intervalo_min> <intervalo_max>");
            return;
        }

        // Obtenemos los parámetros de entrada
        String letra = args[0];
        int intervaloMin, intervaloMax;

        try {
            intervaloMin = Integer.parseInt(args[1]);
            intervaloMax = Integer.parseInt(args[2]);
            if (intervaloMin >= intervaloMax) {
                System.out.println("Error: El intervalo mínimo debe ser menor que el intervalo máximo.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Los intervalos deben ser números enteros.");
            return;
        }

        Random random = new Random();
        int contador = 0;

        // Imprimimos la letra en intervalos aleatorios dentro del rango
        while (contador < 5) { // Imprimimos la letra solo cinco veces
            System.out.println(letra);
            contador++;

            try {
                // Generamos un intervalo aleatorio entre intervaloMin y intervaloMax
                int intervaloAleatorio = intervaloMin + random.nextInt(intervaloMax - intervaloMin + 1);
                Thread.sleep(intervaloAleatorio);
            } catch (InterruptedException e) {
                System.out.println("Proceso interrumpido.");
                break;
            }
        }

        // Imprimir mensaje final al alcanzar las cinco impresiones
        System.out.println("Final de la letra " + letra);
    }
}
