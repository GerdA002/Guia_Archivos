package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Ejercicio002 {

    public static void main(String[] args) {
        String path = "BIBLIA_COMPLETA.txt";
        List<String> palabras = ObtenerPalabras(path);
        Map<String, Integer> FrecuenciaPa = Contardorfre(palabras);
        List<Map.Entry<String, Integer>> Ordenar = ordenarXfre(FrecuenciaPa);
        imprimirPalabrasMasRepetidas(Ordenar, 10);

    }

    public static List<String> ObtenerPalabras(String path) {
        List<String> palabras = new ArrayList<>();

        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                linea = linea.replaceAll("[\\#$@~!¡&*()\\[\\];.,:?^`\\n\\d\\\\\\/]+", "");
                String[] palabrasLinea = linea.split("\\s+");
                palabras.addAll(Arrays.asList(palabrasLinea));
            }
        } catch (Exception e) {
            System.out.println("Se produjo un error al leer el archivo");
        }
        return palabras;
    }

    //Encontrando las palabras repetidas 
    public static Map<String, Integer> Contardorfre(List<String> palabras) {
        Map<String, Integer> frepalabras = new HashMap<>();
        for (String palabra : palabras) {
            frepalabras.put(palabra, frepalabras.getOrDefault(palabra, 0) + 1);
        }
        return frepalabras;
    }

    //ordenando las plabras repetidas 
    public static List<Map.Entry<String, Integer>> ordenarXfre(Map<String, Integer> frepalabras) {
        List<Map.Entry<String, Integer>> ListaPalabras = new ArrayList<>(frepalabras.entrySet());
        ListaPalabras.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return ListaPalabras;
    }

    //imprimiendo las  10 palbras mas repetidas 
    public static void imprimirPalabrasMasRepetidas(List<Map.Entry<String, Integer>> ListaPalabras, int limite) {
        System.out.println("Palabras más repetidas:");
        int contador = 0;
        for (Map.Entry<String, Integer> entrada : ListaPalabras) {
            if (contador >= limite) {
                break;
            }
            System.out.println(entrada.getKey() + ": " + entrada.getValue() + " veces");
            contador++;
        }
    }
}
