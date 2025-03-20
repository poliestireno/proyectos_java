import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteFTP
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


            System.out.println("Introduce la ruta del fichero a transferir y pulsa enter");
            String rutaFichero = entradaConsola.nextLine();
            File fichero = new File(rutaFichero);
            
            if (!fichero.exists())
            {
                System.out.println("No existe el fichero con ruta "+rutaFichero);
            }
            else
            {
                String nombreFichero = fichero.getName();
                salida.write(nombreFichero.getBytes());
                salida.flush();
                
                try (FileInputStream fentrada = new FileInputStream(fichero))
                {
                    while (((bytesLeidos = fentrada.read(buffer))!= -1)) 
                    { 
                        salida.write(buffer,0,bytesLeidos);
                        salida.flush();
                    }
                }
                System.out.println("Fichero enviado correctamente con la ruta "+rutaFichero);
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