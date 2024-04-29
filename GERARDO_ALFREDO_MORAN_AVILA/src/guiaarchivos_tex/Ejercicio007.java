package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio007 {

    public static void main(String[] args) {
        String path="MOCK_DATA.txt";
         String path1="file_malet.txt";
         String path2="file_female.txt";
         DivididoXGenero(path, path1, path2);
         System.out.println("Male");
         ImprimirArchivoMale(path1);
         System.out.println("Female");
         ImprimirArchivoFemale(path2);
    }

    public static void DivididoXGenero(String path, String path1, String path2) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path));
             BufferedWriter maleWriter = new BufferedWriter(new FileWriter(path1));
             BufferedWriter femaleWriter = new BufferedWriter(new FileWriter(path2))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String gender = parts[4].trim().toLowerCase();
                    String formattedLine = formatLine(parts);
                    if (gender.equals("male")) {
                        maleWriter.write(formattedLine);
                        maleWriter.newLine();
                    } else if (gender.equals("female")) {
                        femaleWriter.write(formattedLine);
                        femaleWriter.newLine();
                    }
                }
            }
            
            System.out.println("Archivos separados por género creados con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static String formatLine(String[] parts) {
        StringBuilder formattedLine = new StringBuilder();
        formattedLine.append(parts[1].trim()).append(" ").append(parts[2].trim()).append(": ").append(parts[0].trim());
        return formattedLine.toString();
    }
    
     public static void ImprimirArchivoMale(String path1) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path1));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro al leer el archivo ");
        }
    }
      public static void ImprimirArchivoFemale(String path2) {
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
