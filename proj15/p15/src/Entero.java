
import java.io.Serial;
import java.io.Serializable;

public class Entero implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int valor;
    private boolean esPrimo = false;

    public Entero(int valor, boolean esPrimo) {
        this.valor = valor;
        this.esPrimo = esPrimo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isEsPrimo() {
        return esPrimo;
    }

    public void setEsPrimo(boolean esPrimo) {
        this.esPrimo = esPrimo;
    }

    @Override
    public String toString() {
        return "Entero{" +
                "valor=" + valor +
                ", esPrimo=" + esPrimo +
                '}';
    }
    
}
