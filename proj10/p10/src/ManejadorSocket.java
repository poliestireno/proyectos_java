
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorSocket implements Runnable
{
    private Socket socketClient;
    public ManejadorSocket (Socket socketClient)
    {
        this.socketClient=socketClient;
    }
    @Override
    public void run() 
    {   
        BufferedReader entrada=null;
        PrintWriter salida=null;
        try {
            entrada = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            salida = new PrintWriter(socketClient.getOutputStream(),true);
            String mensaje;
            while ((mensaje = entrada.readLine())!=null) 
            { 
                System.out.println("Mensaje recibido en el cliente del servidor: "+mensaje);
                salida.println("Hola Servidor soy el cliente, he recibido este mensaje:"+mensaje);
            }

        } catch (IOException e) {
            System.out.println("Error en el ManejadorSocket "+e.getMessage());
        }
        finally
        {
            try {
                entrada.close();
                salida.close();
                socketClient.close();
            } catch (Exception e) {
                System.out.println("Error en el ManejadorSocket cerrando recursos"+e.getMessage());
            }
        }
        

    }

}
