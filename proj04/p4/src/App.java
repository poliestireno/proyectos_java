public class App {
    public static void main(String[] args) throws Exception 
    {
        
        MiBuffer mb1 = new MiBuffer(5);

        mb1.producir(12);
        mb1.producir(13);
        mb1.producir(14);
        mb1.producir(15);
        mb1.producir(16);
        mb1.producir(17);

        
        System.out.println(mb1);
    }
}
