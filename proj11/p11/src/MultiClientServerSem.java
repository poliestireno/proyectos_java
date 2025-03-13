import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class MultiClientServerSem {

    static final int MAX_CONEXIONES = 2;
    private static final Semaphore semaforo = new Semaphore(MAX_CONEXIONES,true);
    private static final int PUERTO = 7777;
    
    public static void main(String[] args) throws Exception 
    {

        try (ServerSocket serverSocket = new ServerSocket(PUERTO))
        {
            System.out.println("Servidor levantado");
            while(true)
            {
                semaforo.acquire(); // hay hueco?

                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado. Conexiones activas:"+(MAX_CONEXIONES-semaforo.availablePermits()));
                // Lanzar hilo manejador del clienteSocket
                ManejadorSocketSem clienteManejador = new ManejadorSocketSem(clienteSocket,semaforo);
                new Thread(clienteManejador).start();
            }
        }
        catch (IOException e) 
        {
            System.out.println("Error en el servidor"+e.getMessage());
        } 




    }
}
