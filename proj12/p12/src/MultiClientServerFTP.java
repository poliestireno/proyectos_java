import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClientServerFTP {

    private static final int PUERTO = 7777;
    
    public static void main(String[] args) throws Exception 
    {

        try (ServerSocket serverSocket = new ServerSocket(PUERTO))
        {
            System.out.println("Servidor levantado");
            while(true)
            {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado");
                // Lanzar hilo manejador del clienteSocket
                ManejadorSocketFTP clienteManejador = new ManejadorSocketFTP(clienteSocket);
                new Thread(clienteManejador).start();
            }
        }
        catch (IOException e) 
        {
            System.out.println("Error en el servidor"+e.getMessage());
        } 




    }
}
