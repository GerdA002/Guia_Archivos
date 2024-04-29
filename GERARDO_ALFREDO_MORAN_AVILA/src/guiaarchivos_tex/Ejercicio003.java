package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ejercicio003 {

    public static void main(String[] args) {
        String path = "BIBLIA_COMPLETA.txt";
        Set<String> palabrasIng = obtenerPalabrasIgnoradas(path);
        List<String> palabr = ObtenerPalabras(path);
        Map<String, Integer> frepalabra = contarFre(palabr, palabrasIng);
        List<Map.Entry<String, Integer>> listaOrden = ordenarXfre(frepalabra);
        imprimirPalabrasMasRepetidas(listaOrden, 10);

    }

    //metodo para obtener las palabras 
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
    //metodo para encontrar las palbras mas repetidas 

    public static Map<String, Integer> contarFre(List<String> palabras, Set<String> palabrasIgnoradas) {
        Map<String, Integer> frecuenciaPalabras = new HashMap<>();
        for (String palabra : palabras) {
            if (!palabrasIgnoradas.contains(palabra)) {
                frecuenciaPalabras.put(palabra, frecuenciaPalabras.getOrDefault(palabra, 0) + 1);
            }
        }
        return frecuenciaPalabras;
    }

    //ordenando las palbras 
    public static List<Map.Entry<String, Integer>> ordenarXfre(Map<String, Integer> frecuenciaPalabras) {
        List<Map.Entry<String, Integer>> listaPalabras = new ArrayList<>(frecuenciaPalabras.entrySet());
        listaPalabras.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return listaPalabras;
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

    public static Set<String> obtenerPalabrasIgnoradas(String path) {
        Set<String> palabrasIgnoradas = new HashSet<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String palabra;
            while ((palabra = lector.readLine()) != null) {
                palabrasIgnoradas.add(palabra);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de palabras ignoradas: " + e.getMessage());
        }
        return palabrasIgnoradas;
    }

}
