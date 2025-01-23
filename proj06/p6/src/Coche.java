import java.util.Random;

public class Coche implements Runnable
{
    private final Parking parking;
    private final String nombre;
    private final int n_color;
    String[] colors = {

        "\u001B[31m", // Rojo

        "\u001B[32m", // Verde

        "\u001B[33m", // Amarillo

        "\u001B[34m", // Azul

        "\u001B[35m", // Morado

        "\u001B[36m", // Cian

        "\u001B[37m", // Blanco

        "\u001B[90m"  // Gris

};
    public Coche(Parking parking, String nombre,int n_color)
    {
        this.nombre=nombre;
        this.parking=parking;
        this.n_color=n_color;
        
    }

    @Override
    public void run() 
    {
        try {
            parking.entrar(nombre);
            System.out.println(colors[n_color%8]+"EL COCHE "+nombre+" ESTÁ COMPRANDO");
            int timer = new Random().nextInt(3000);
            Thread.sleep(timer);
            parking.salir(nombre);
        } catch (InterruptedException ex) 
        {
            System.out.println("El coche "+nombre+ " fue interrumpido");
        }  
    }
    
}
