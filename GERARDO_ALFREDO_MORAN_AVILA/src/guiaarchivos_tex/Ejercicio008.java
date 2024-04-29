package guiaarchivos_tex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio008 {

    public static void main(String[] args) {
        String path = "MOCK_DATA.txt";
        eliminarReguistroDuplicado(path);

    }

    static class Registro {

        private String direccionIP;
        private String datos;

        public Registro(String direccionIP, String datos) {
            this.direccionIP = direccionIP;
            this.datos = datos;
        }

        public String getDireccionIP() {
            return direccionIP;
        }

        public void setDireccionIP(String direccionIP) {
            this.direccionIP = direccionIP;
        }

        public String getDatos() {
            return datos;
        }

        public void setDatos(String datos) {
            this.datos = datos;
        }

        public String imprimir() {
            return "Registro[DireccionIp=" + direccionIP + ", datos  " + datos + "]";
        }

    }

    public static void eliminarReguistroDuplicado(String path) {
        List<Registro> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String direccionIP = partes[0];
                String datos = partes[1];
                registros.add(new Registro(direccionIP, datos));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo" + e.getMessage());
            return;
        }
        Set<String> ipVisitas = new HashSet<>();
        List<Registro> registrosSinduplicados = new ArrayList<>();
        for (Registro registro : registros) {
            if (!ipVisitas.contains(registro.getDireccionIP())) {
                ipVisitas.add(registro.getDireccionIP());
                registrosSinduplicados.add(registro);
            }
        }
        System.out.println("\nRegistros sin duplicados");
        for (Registro registro : registrosSinduplicados) {
            System.out.println(registro.imprimir());
        }

    }

}
