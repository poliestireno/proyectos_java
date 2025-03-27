import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteAtomic
{
    public static void main(String[] args) 
    {
        String host ="localhost";
        int puerto = 7777;

        try (Socket socket = new Socket(host,puerto))
        {
            System.out.println("Conectando al servidor...");

            InputStream entrada = socket.getInputStream();
            OutputStream salida = socket.getOutputStream();
            Scanner entradaConsola = new Scanner(System.in);

            // lectura de la bienvenida del servidor
            byte[] buffer = new byte[1014];
            int bytesLeidos = entrada.read(buffer);
            System.out.println("Servidor:"+new String(buffer,0,bytesLeidos));

            while (true) { 
                String mensaje = entradaConsola.nextLine();
                if (mensaje.equals("salir"))
                {
                    break;
                }
                salida.write(mensaje.getBytes());
                salida.flush();

                bytesLeidos = entrada.read(buffer);
                System.out.println("ECO Servidor:"+new String(buffer,0,bytesLeidos));
            }
            entradaConsola.close();
            salida.close();
            entrada.close();
        }
        catch (IOException e) 
        {
            System.out.println("Error en el cliente "+e.getMessage());
        }       
    }
}