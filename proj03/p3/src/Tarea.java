class Tarea implements Runnable
{
    
    private final int tiempo;
    private final String nombre;
    public Tarea(String nombreTarea, int tiempoDormido) 
    {
        this.tiempo=tiempoDormido;
        this.nombre=nombreTarea;
    }

    @Override
    public void run() 
    {
        try {
            System.out.println(this.nombre+":inicio ejecución");
            Thread.sleep(this.tiempo);
            System.out.println(this.nombre+":fin ejecución");
        } catch (InterruptedException e) {

            System.out.println("Exception"+e.getMessage());
        }  
    }

}
