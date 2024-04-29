package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio005 {

    public static void main(String[] args) {
        String path = "MOCK_DATA.txt";
        buscarId(path, "1");
        buscarId(path, "5");
    }

    public static void buscarId(String path, String id) {
        try {
            File archi = new File(path);
            FileReader fr = new FileReader(archi);
            BufferedReader buf;
            BufferedReader br = new BufferedReader(fr);
            String linea;

            boolean encontrado = false;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String ide = partes[0].trim();

                if (ide.equals(id)) {
                    encontrado = true;
                    System.out.println("Registro encontrado:");
                    System.out.println(linea);
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Redistro con ID:" + id + " no encontrado");
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Se produjo un error al intetar leer el archivo" + e.getMessage());
        }
    }
}
