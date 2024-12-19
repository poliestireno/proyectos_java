import java.util.Random;

public class Consumidor implements Runnable{

    private final MiBuffer buffer;
    private final int timer;

    public Consumidor(MiBuffer bu, int min_timer, int max_timer)
    {
        this.buffer = bu;
        this.timer = new Random().nextInt(max_timer-min_timer+1)+min_timer;
    }
  
    @Override
    public void run() 
    {
        while(true)
        {
            try {
                int c = buffer.consumir();
                Thread.sleep(timer);
                System.out.println("Consume elemento "+c);
                System.out.println(buffer);
           } catch (InterruptedException e) 
            {
                Thread.currentThread().interrupt();
            }
            
        }

    }

}
