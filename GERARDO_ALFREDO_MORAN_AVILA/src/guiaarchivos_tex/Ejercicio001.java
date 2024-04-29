package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Ejercicio001 {
    
        public static  void main(String[] args){
        String path="BIBLIA_COMPLETA.txt";
        String palabra="Dios";
        
      int cantidad=ContarPalabra(path, palabra);
        System.out.println(cantidad);

}

    public  static int ContarPalabra(String path,String palabra){
      int contador=0;
        Pattern patron=Pattern.compile("\\b"+palabra+"\\b");
        try {
            FileReader fr=new FileReader(path);
            BufferedReader br=new BufferedReader(fr);
            
            String Liena;
            
            while ((Liena=br.readLine())!=null) {                
                String[]palabras=Liena.split(" ");
                for(String p:palabras){
                    if (patron.matcher(p).find()) {
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
            return contador;
        
    
    
}
    }