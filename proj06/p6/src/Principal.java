public class Principal {

    public static void main(String[] args) 
    {
        Parking miParking = new Parking(5);

        for (int i = 1; i <= 10; i++) 
        {
            new Thread(new Coche(miParking,"Coche_"+i,i)).start();
        }
    }
    
}
