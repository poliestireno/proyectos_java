
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    public static void main(String[] args) throws Exception 
    {
        
        System.out.println("Hello, World!");

        
        
        BlockingQueue <Integer> buffer = new ArrayBlockingQueue<>(5);

        Thread productor = new Thread(() -> {

            try {
                for (int i = 0; i < 10; i++) 
                {
                    buffer.put(i);
                    System.out.println("Introducido elemento "+i);
                }               
            } 
            catch (InterruptedException ex) 
            {
                System.out.println("error: "+ex.getMessage());
            }
        }); 
        Thread consumidor = new Thread(() -> {

            try {
                for (int i = 0; i < 10; i++) 
                {
                    buffer.take();
                    Thread.sleep((long)(Math.random()*10000));
                    System.out.println("Introducido consumido "+i);
                }               
            } 
            catch (InterruptedException ex) 
            {
                System.out.println("error: "+ex.getMessage());
            }
        }); 


        consumidor.start();
        productor.start();

    }
}
