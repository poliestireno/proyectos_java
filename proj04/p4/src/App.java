public class App {
    public static void main(String[] args) throws Exception 
    {
        
        MiBuffer mb1 = new MiBuffer(10);

        Thread pro1 = new Thread(new Productor(mb1,0, 110, 1100));
        Thread pro2 = new Thread(new Productor(mb1,1000, 110, 1100));
        
        Thread con1 = new Thread(new Consumidor(mb1, 0,110, 1100));
        Thread con2 = new Thread(new Consumidor(mb1, 1, 110, 1100));    

        
        con1.start();
        con2.start();
        
        pro1.start();
        pro2.start();
        

        




    }
}
