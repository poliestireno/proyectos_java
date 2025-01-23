public class Parking 
{
    private final int capacidad;
    private int n_ocupadas = 0;

    public Parking(int in_capa)
    {
        this.capacidad=in_capa;
    }

    public synchronized void entrar(String nombre_coche) throws InterruptedException
    {
        while (n_ocupadas==this.capacidad) 
        { 
            System.out.println("BLOQUEADOOOOOOOO El coche "+nombre_coche+" no puede pasar");
            wait();    
        }       
        n_ocupadas++;
        System.out.println("El coche "+nombre_coche+" YA HA ENTRADO Y APARCADO");
    }
    
    public synchronized void salir(String nombre_coche)
    {
        n_ocupadas--;
        System.out.println("SALEEEE el coche "+nombre_coche+" YA HA ENTRADO Y APARCADO");
        notifyAll();
    }
    

}
