import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSer {
    
    private static final String HOST = "localhost";
    private static final int PUERTO = 5000;

    public static void main(String[] args) {
        
        try (Socket socket = new Socket(HOST, PUERTO)) 
        {
            System.out.println("Conectado al servidor en " + HOST + ":" + PUERTO);

            Entero entero = new Entero(25, false);
            
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());

            salida.writeObject(entero);
            salida.flush();
            salida.close();
            socket.close();
            System.out.println("Entero enviado: " + entero);
        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
