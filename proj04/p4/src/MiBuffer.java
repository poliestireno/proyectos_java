
import java.util.LinkedList;
import javax.print.attribute.standard.Sides;

public class MiBuffer 
{
    private final int capacidad;
    private final LinkedList<Integer> cola = new LinkedList<>();

    public MiBuffer (int in_capacidad)
    {
        this.capacidad=in_capacidad;
    }
    public synchronized void producir(int value)
    {
        while (cola.size()==capacidad) 
        {            
            wait();
        }
        cola.add(value);
    }
    public synchronized int consumir()
    {
        int value = cola.removeFirst();
        notifyAll();
        return value;
    }

    @Override
    public String toString() {
        return "MiBuffer con capacidad "+capacidad+" contiene "+cola.toString();
    }

}
