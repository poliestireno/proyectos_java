import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ManejadorSocketFTP implements Runnable{

    private final Socket clienteSocket;
    private static final String DIRECTORIO_SERVIDOR = System.getProperty("user.dir")+File.separator+"directorio_servidor";
    
    public ManejadorSocketFTP(Socket clienteSocket) 
    {
        this.clienteSocket=clienteSocket;
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public void run() {
        try {

            InputStream entrada = clienteSocket.getInputStream();
            OutputStream salida = clienteSocket.getOutputStream();


            File directorio = new File(DIRECTORIO_SERVIDOR);
            if (!directorio.exists())
            {
                boolean creadoOk = directorio.mkdirs();
                System.out.println("Directorio creado correctamente "+creadoOk+" en "+DIRECTORIO_SERVIDOR);
            }

            salida.write("Bienvenido!, estás conectado a mí".getBytes());
            salida.flush();

            // leer nombre del fichero
            byte[] buffer = new byte[1014];
            int bytesLeidos = entrada.read(buffer);
            String nombreFichero = new String(buffer,0,bytesLeidos).trim();

            File ficheroDestino = new File(DIRECTORIO_SERVIDOR+File.separator+nombreFichero);
            
            try (FileOutputStream fdestino = new FileOutputStream(ficheroDestino))
            {
                while (((bytesLeidos = entrada.read(buffer))!= -1)) 
                { 
                    fdestino.write(buffer,0,bytesLeidos);
                }
            }

            System.out.println("Fichero correctamente transferido");

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
            System.out.println("cliente desconectado");
        }
        


    }

}
