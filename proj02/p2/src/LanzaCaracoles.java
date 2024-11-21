import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LanzaCaracoles {
    public static void main(String[] args) {
        
        String[][] parametros =
        {
            {"10","A"},
            {"1","B"}
        };

        try
        {
            List<Process> listaProcesos = new ArrayList<>();
            for (String[] param : parametros)
            {
                ProcessBuilder pb = new ProcessBuilder("java","-cp","bin","Caracol",param[0],param[1]);
                Process p = pb.start();
                listaProcesos.add(p);
                BufferedReader lectorSalida = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String linea;
                while((linea = lectorSalida.readLine())!=null)
                {
                    System.out.println(linea);
                }
            }
            //falta meter hilos y el waitFor para esperar a todos los procesos.




            
        }
        catch (IOException ee)
        {
            System.out.println("Ex:"+ee.getMessage());
        }
        
    }
}
