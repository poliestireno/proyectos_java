public class MultiHilo 
{
    public static void main(String[] args) {
        
        Thread h1 = new Thread(new Tarea("h1",3000));
        Thread h2 = new Thread(new Tarea("h2",1000));
        Thread h3 = new Thread(new Tarea("h3",3000));

        
        h1.setPriority(Thread.MIN_PRIORITY);
        h2.setPriority(6);
        h3.setPriority(Thread.MAX_PRIORITY);
        
        h1.start();
        h2.start();
        h3.start();      
        /*
        try {
            h1.join(); // espera que los otros hilos acaben
            System.out.println("FFF h1");
        } catch (InterruptedException e) {
            System.out.println("Exception"+e.getMessage());
        }
            */
        while(h1.isAlive() || h2.isAlive() || h3.isAlive())
        {
            System.out.println("yield");
            Thread.yield(); // cede el control al procesador
        }
        System.out.println("todos los hilos has terminado");

    }
}
