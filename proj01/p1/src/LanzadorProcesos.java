import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LanzadorProcesos {
    public static void main(String[] args) 
    {
        ProcessBuilder pb = new ProcessBuilder("java","-cp","/home/gilbert/.config/Code/User/workspaceStorage/78787eb821848071f7cf50e4c766382c/redhat.java/jdt_ws/proyectos_java_6ca5d6b1/bin","ProcesoP01","hola");
        try{

            Process proceso = pb.start();
            BufferedReader lectorSalida = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while((linea = lectorSalida.readLine())!=null)
            {
                System.out.println("Extraido del proceso: "+linea);
            }
            System.out.println("Con PID:"+proceso.pid());
            Process proceso2 = pb.start();
            lectorSalida = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
            while((linea = lectorSalida.readLine())!=null)
            {
                System.out.println("Extraido del proceso: "+linea);
            }
            System.out.println("Con PID:"+proceso2.pid());
            
            //que los ProcesoP01 ("jose")

        }
        catch (Exception ee)
        {
            System.out.println("Exception "+ee.getMessage());
        }
        System.out.println("Fin de ejecución Proceso padre lanzador");
    }

}
