
import java.util.concurrent.SynchronousQueue;

public class App {
    public static void main(String[] args) throws Exception 
    {

        SynchronousQueue<String> callCenter = new SynchronousQueue<>();

        long inicio = System.currentTimeMillis();

        for (int i = 0; i < 3; i++) 
        {
            int operadorId = i;
            new Thread( () -> 
            {
                while(true)
                    {
                System.out.println("Operador "+operadorId+" esperando llamada");
                String llamada;
                try {
                    
                        llamada = callCenter.take();              
                        System.out.println("Operador "+operadorId+" recibe la llamada del cliente "+llamada);
                        Thread.sleep(5000);
                        System.out.println("Operador "+operadorId+" finaliza llamada");
                    

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }
            ).start();
        }
        for (int i = 0; i < 15; i++) 
        {
            int clienteId = i;
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread( () -> 
            {
                try {

                    System.out.println("Cliente "+clienteId+" llamando...");
                    callCenter.put(""+clienteId);
                    long tiempoTrans = (System.currentTimeMillis() - inicio);
                    System.out.println("Cliente "+clienteId+" está siendo atendido en tiempo "+tiempoTrans);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ).start();
            
        }
    }
}
