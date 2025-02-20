import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) 
    {
        String host ="localhost";
        int puerto = 12345;
        try (Socket socket = new Socket(host,puerto))
        {
            System.out.println("Conectado al servidor");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter salida = new PrintWriter(socket.getOutputStream(),true);

            salida.println("HOLA SOY EL CLIENTE");

            entrada.close();
            salida.close();

        }
        catch (IOException e) 
        {
            System.out.println("Error en el cliente "+e.getMessage());
        }
    }
}