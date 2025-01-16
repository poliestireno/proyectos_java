
import java.util.concurrent.Semaphore;


public class Person implements Runnable
{
    private final Semaphore sem;
    private final String nombre;
    private final int tardon;
    public Person (Semaphore sem, String nombre, int tardon)
    {
        this.sem=sem;
        this.nombre=nombre;
        this.tardon = tardon;
    }
    @Override
    public void run() 
    {
        try 
        {
            System.out.println("Pide permiso "+nombre);
            sem.acquire(); // pide permiso para entrar en un hueco    
            System.out.println("Trabajando "+nombre+" con tardon "+tardon);      
            Thread.sleep(tardon);
  
        } catch (InterruptedException e) 
        {
            System.out.println("Hilo interrumpido "+e.getMessage());
        }
        finally
        {
            System.out.println("Termina "+nombre);
            sem.release(); // libera un hueco
        }      
    }
}
