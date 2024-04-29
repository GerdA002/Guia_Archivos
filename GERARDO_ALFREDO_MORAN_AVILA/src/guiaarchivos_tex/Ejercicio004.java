package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio004 {

    public static void main(String[] args) {
        String path = "MOCK_DATA.txt";
        String encabezado = "id,first_name,last_name,email,gender,ip_address";
        agregarencabezado(path, encabezado);
        System.out.println("en cabezado agregado corectamente ");
        ImprimirArchivo(path);

    }

    public static void agregarencabezado(String path, String encabezado) {
        try {
            BufferedReader vr = new BufferedReader(new FileReader(path));
            String conten = "";
            String linea;
            while ((linea = vr.readLine()) != null) {
                conten += linea + "\n";
            }
            vr.close();

            BufferedWriter vw = new BufferedWriter(new FileWriter(path));
            vw.write(encabezado + "\n" + conten);
            vw.close();
        } catch (Exception e) {
            System.err.println("Error al intertar escribir el archivo" + e.getMessage());

        }
    }

    public static void ImprimirArchivo(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro al leer el archivo ");
        }
    }

}
