import java.util.Random;

public class Productor implements Runnable{

    private final MiBuffer buffer;
    private final int nivel;
    private final int timer;
    
    public Productor(MiBuffer bu,int nivel,int min_timer, int max_timer)
    {
        this.buffer = bu;
        this.nivel=nivel;
        this.timer = new Random().nextInt(max_timer-min_timer+1)+min_timer;
    }
    
    @Override
    public void run() 
    {
        int ni = nivel;
        while(true)
        {           
            try {
                buffer.producir(ni);
                Thread.sleep(timer);
                System.out.println("PRODUCCCCCCCCEEEEE elemento "+ni);
                System.out.println(buffer);  
                ni++;              
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
