public class App {
    public static void main(String[] args) throws Exception 
    {
        
        MiBuffer mb1 = new MiBuffer(5);

        Thread pro1 = new Thread(new Productor(mb1,0, 1000, 2000));
        //Thread pro2 = new Thread(new Productor(mb1,0, 1000, 2000));
        
        Thread con1 = new Thread(new Consumidor(mb1, 3000, 5000));
        //Thread con2 = new Thread(new Consumidor(mb1, 2000, 2000));

        
        pro1.start();
        //pro2.start();
        con1.start();
        




    }
}
