import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;

public class Client2 {
    public static void main(String[] args) 
    {
        String host ="localhost";
        int puerto = 8888;

        String idUnico = UUID.randomUUID().toString();


        try (Socket socket = new Socket(host,puerto))
        {
            System.out.println("Conectado al servidor");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);

            BufferedReader entradaConsola = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Escribe tus mensajes o la palabra fin");
            String mensaje;
            while (!(mensaje = entradaConsola.readLine()).equalsIgnoreCase("fin"))
            {
                salida.println("cliente id "+idUnico+":"+mensaje);
                System.out.println("SERVIDOR DICE: "+entrada.readLine());
            }
            salida.println("");
            entrada.close();
            salida.close();

        }
        catch (IOException e) 
        {
            System.out.println("Error en el cliente "+e.getMessage());
        }
    }
}