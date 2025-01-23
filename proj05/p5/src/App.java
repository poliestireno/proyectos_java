
import java.util.Random;
import java.util.concurrent.Semaphore;

public class App {
    public static void main(String[] args) throws Exception 
    {
        
        Semaphore sem = new Semaphore(1);

        for (int i = 1; i < 9; i++)
        {
            int timer = new Random().nextInt(i*1000-500+1)+500;
            new Thread(new Person(sem,"persona"+i,timer)).start();
        }
        


    }
}
