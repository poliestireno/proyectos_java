import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServer {
    public static void main(String[] args) throws Exception 
    {
        int puerto = 8888;

        try (ServerSocket serverSocket = new ServerSocket(puerto))
        {
            System.out.println("Servidor levantado");
            while(true)
            {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado");
                // Lanzar hilo manejador del clienteSocket
                ManejadorSocket clienteManejador = new ManejadorSocket(clienteSocket);
                new Thread(clienteManejador).start();
            }
        }
        catch (IOException e) 
        {
            System.out.println("Error en el servidor"+e.getMessage());
        } 




    }
}
