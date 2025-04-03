import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSer {

    private static final int PUERTO = 5000;
    
    public static void main(String[] args)
    {

        try (ServerSocket serverSocket = new ServerSocket(PUERTO))
        {
            System.out.println("Servidor levantado");

            //while(true)
            //{
                // Aceptar conexiones de clientes
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde "+clienteSocket.getInetAddress());
                
                ObjectInputStream entrada = new ObjectInputStream(clienteSocket.getInputStream());
                Entero enteroRecibido = (Entero) entrada.readObject();
                System.out.println("Entero recibido: " + enteroRecibido);
                serverSocket.close();
            //}
        }
        catch (IOException  e) 
        {
            System.out.println("Error IO "+e.getMessage());
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("Error ClassNot "+e.getMessage());
        } 
    }
}
