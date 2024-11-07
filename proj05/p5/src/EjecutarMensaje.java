// Archivo: EjecutarMensaje.java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class EjecutarMensaje {
    public static void main(String[] args) {
        // Crear un ProcessBuilder que ejecute la clase Mensaje
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "Mensaje");

        try {
            // Iniciar el proceso
            Process proceso = pb.start();

            // Leer la salida estándar del proceso (stdout)
            BufferedReader lectorSalida = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = lectorSalida.readLine()) != null) {
                System.out.println("Salida de Mensajedfff2: " + linea);
            }

            // Leer la salida de error del proceso (stderr)
            BufferedReader lectorError = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
            while ((linea = lectorError.readLine()) != null) {
                System.err.println("Error de Mensaje: " + linea);
            }

            // Esperar a que el proceso termine y obtener el código de salida
            int codigoSalida = proceso.waitFor();
            System.out.println("El proceso terminó con el código de salida: " + codigoSalida);

        } catch (IOException e) {
            System.out.println("Ocurrió un error al ejecutar la clase Mensaje.");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("El proceso fue interrumpido.");
            e.printStackTrace();
        }
    }
}
 