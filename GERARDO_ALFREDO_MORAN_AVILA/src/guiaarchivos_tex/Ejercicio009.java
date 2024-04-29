package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio009 {

    public static void main(String[] args) {
        String path = "MOCK_DATA.txt";
        ContarRegistroIp(path, "170.");
    }

    public static void ContarRegistroIp(String path, String RangoIp) {
        int cantidad = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String direccionIp = partes[5];
                if (direccionIp.startsWith(RangoIp)) {
                    cantidad++;

                }
            }
            br.close();
            System.out.println("Cantidad de registros cuya Ip pertenece al rango " + RangoIp + ":" + cantidad);
        } catch (IOException e) {
            System.out.println("Error el leer el registro");

        }

    }

}
