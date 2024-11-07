// Archivo: EjecutarCaracol.java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EjecutarCaracol {
    public static void main(String[] args) {
        // Definir los parámetros para cada proceso
        String[][] parametros = {
            {"A", "500", "1000"}, // Letra "A" con intervalo aleatorio entre 500 y 1000 ms
            {"B", "500", "1000"}, // Letra "B" con intervalo aleatorio entre 1000 y 1500 ms
            {"C", "500", "1000"}  // Letra "C" con intervalo aleatorio entre 1500 y 2000 ms
        };

        // Lista para almacenar los procesos
        List<Process> procesos = new ArrayList<>();

        try {
            // Crear y lanzar los procesos
            for (String[] param : parametros) {
                // Incluir el directorio ./bin en el CLASSPATH
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "/home/gilbert/.config/Code/User/workspaceStorage/58dc4b84c0d29517665d3f49369a610a/redhat.java/jdt_ws/proj05_89cb9740/bin", "Caracol", param[0], param[1], param[2]);
                Process proceso = pb.start();
                procesos.add(proceso);

                // probar primero sin crear hilos y ver que hace un proceso despues de otro
      new Thread(() -> {
                    try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                        String linea;
                        while ((linea = lector.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            // Esperar a que los procesos terminen (opcional)
            for (Process proceso : procesos) {
                proceso.waitFor();
            }
            System.out.println("Todos los procesos han finalizado");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar los procesos Caracol.yyyyyyy");
            e.printStackTrace();
        }
    }
}
