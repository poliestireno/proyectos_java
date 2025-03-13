import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Semaphore;

public class ManejadorSocketSem implements Runnable{

    private final Socket clienteSocket;
    private final Semaphore semaforo;
    
    public ManejadorSocketSem(Socket clienteSocket, Semaphore semaforo) 
    {
        this.clienteSocket=clienteSocket;
        this.semaforo=semaforo;
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void run() {
        try {

            InputStream entrada = clienteSocket.getInputStream();
            OutputStream salida = clienteSocket.getOutputStream();

            salida.write("Bienvenido!, estás conectado a mí".getBytes());


            byte[] buffer = new byte[1014];
            int bytesLeidos;
            while ((bytesLeidos = entrada.read(buffer)) != -1) 
            { 
                salida.write(buffer,0,bytesLeidos);
                System.out.println("buffer:"+ new String(buffer,0,bytesLeidos));
            }


        } catch (IOException e) {
            System.out.println("Error en el ManejadorSocket "+e.getMessage());
        }
        finally
        {
            try {                
                clienteSocket.close();
            } catch (Exception e) {
                System.out.println("Error en el ManejadorSocket cerrando recursos"+e.getMessage());
            }
            semaforo.release();
            System.out.println("cliente desconectado");
        }
        


    }

}
