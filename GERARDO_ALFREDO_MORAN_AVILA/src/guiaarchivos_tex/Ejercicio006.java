package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio006 {

    public static void main(String[] args) {
        String path = "MOCK_DATA.txt";
        String path2 = "MOCK_DATA_REPLA.txt";
        procesarArchivo(path, path2);
        ImprimirArchivo(path2);
    }

    public static void procesarArchivo(String path, String path2) {
        try (BufferedReader lector = new BufferedReader(new FileReader(path)); 
                BufferedWriter escritor = new BufferedWriter(new FileWriter(path2))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2) {
                    String nombre = partes[1].trim();
                    String apellido = partes[2].trim();
                    String codigo = generarCodigo(nombre, apellido);
                    escritor.write(nombre + " " + apellido + ": " + codigo);
                    escritor.newLine();
                }
            }
            System.out.println("Archivo de salida creado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al procesar los archivos: " + e.getMessage());
        }
    }

    private static String generarCodigo(String nombre, String apellido) {
    StringBuilder codigo = new StringBuilder();
    String[] nombres = nombre.split(" ");
    String[] apellidos = apellido.split(" ");

    char inicialNombre = nombres[0].toUpperCase().charAt(0);
    
    codigo.append(inicialNombre);
    
    // Verificar si el apellido tiene al menos un elemento
    if (apellidos.length > 0) {
        char inicialApellido = apellidos[0].toUpperCase().charAt(0);
        codigo.append(inicialApellido);
        
        // Obtener la longitud del apellido
        int longitudApellido = apellido.length();
        
        // Agregar dos ceros a la izquierda y luego la longitud del apellido
        codigo.append(String.format("%03d", longitudApellido));
    }
    
    return codigo.toString();
}




    public static void ImprimirArchivo(String path2) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path2));
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
