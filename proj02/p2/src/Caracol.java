import java.util.Random;

public class Caracol {
    public static void main(String[] args) throws Exception 
    {
        int retardoMax = Integer.parseInt(args[0]);
        Random rd = new Random();
        int retardoActual = rd.nextInt(retardoMax)+1;
        Thread.sleep(retardoActual*1000);
        System.out.println(args[1]);
    }
}
