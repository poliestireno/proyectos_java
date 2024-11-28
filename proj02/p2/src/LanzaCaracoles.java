import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LanzaCaracoles {
    public static void main(String[] args) {

        String[][] parametros = {
                { "10", "B" },
                { "1", "A" }
        };

        try {
            List<Process> listaProcesos = new ArrayList<>();
            for (String[] param : parametros) {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp",
                        "/home/gilbert/.config/Code/User/workspaceStorage/5f8a6ee0f4555d5ce3e3da216edb1520/redhat.java/jdt_ws/proyectos_java_16aea38/bin",
                        "Caracol", param[0], param[1]);
                Process p = pb.start();
                listaProcesos.add(p);

                new Thread(() -> {
                    try {
                        String linea;
                        BufferedReader lectorSalida = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        while ((linea = lectorSalida.readLine()) != null) {
                            System.out.println(linea);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

            for (Process pp : listaProcesos) {
                pp.waitFor();
            }

        } catch (IOException | InterruptedException ee) {
            System.out.println("Ex:" + ee.getMessage());
        }

    }
}
