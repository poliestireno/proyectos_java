
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception     
    {
        int puerto = 12345;

        try (ServerSocket serverSocket = new ServerSocket(puerto))
        {
            System.out.println("Iniciado Servidor en el puerto "+puerto);

            // esperar a algún cliente
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado al puerto "+puerto);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(),true);

            String mensajeCliente = entrada.readLine();

            System.out.println("Mensaje recibido del cliente:"+mensajeCliente);

            salida.println("SERVIDOR: Hola cliente, he recibido tu mensaje");

            entrada.close();
            salida.close();
            clienteSocket.close(); 

        } 
        catch (IOException e) 
        {
            System.out.println("Error en el servidor"+e.getMessage());
        }    

    }
}
