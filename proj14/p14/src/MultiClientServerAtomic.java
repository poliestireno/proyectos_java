import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiClientServerAtomic {

    static final int MAX_CONEXIONES = 2;
    private static final int PUERTO = 7777;
    private static final AtomicInteger conexionesActivas = new AtomicInteger();
    
    public static void main(String[] args)
    {

        try (ServerSocket serverSocket = new ServerSocket(PUERTO))
        {
            System.out.println("Servidor levantado");

            while(true)
            {
                if (conexionesActivas.get()<MAX_CONEXIONES)
                {
                    Socket clienteSocket = serverSocket.accept();
                    int conAct = conexionesActivas.incrementAndGet();
                    System.out.println("Cliente conectado. Conexiones activas:"+conAct);
                    // Lanzar hilo manejador del clienteSocket
                    ManejadorSocketAtomic clienteManejador = new ManejadorSocketAtomic(clienteSocket);
                    new Thread(clienteManejador).start();
                }
                else
                {
                    System.out.println("Máximo de conexiones alcanzado. Rechazando conexión");
                    Thread.sleep(1000);
                }   
            }
        }
        catch (IOException | InterruptedException e) 
        {
            System.out.println("Error en el servidor"+e.getMessage());
            Thread.currentThread().interrupt();
        } 
    }
    public static void desconectarCliente()
    {
        int conAct= conexionesActivas.decrementAndGet();
        System.out.println("Cliente desconectado. Conexiones activas: "+conAct);
    }
}
