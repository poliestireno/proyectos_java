
import java.util.LinkedList;

public class MiBuffer 
{
    private final int capacidad;
    private final LinkedList<Integer> cola = new LinkedList<>();

    public MiBuffer (int in_capacidad)
    {
        this.capacidad=in_capacidad;
    }
    public synchronized void producir(int value) throws InterruptedException
    {
        while (cola.size()==capacidad) 
        {            
            System.out.println("BLOQUEADO PRODUCTOR para elemento "+value);
            wait();
        }
        cola.add(value);
        notifyAll();        
    }
    public synchronized int consumir() throws InterruptedException
    {
        while (cola.isEmpty()) 
        {            
            System.out.println("BLOQUEADO CONSUMIDOR COLA VACIAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            wait();
        }
        int value = cola.removeFirst();
        notifyAll();
        return value;
    }

    @Override
    public String toString() {
        return "MiBuffer con capacidad "+capacidad+" contiene "+cola.toString();
    }

}
