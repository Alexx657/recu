package uf3;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class RedTransporte {
    // Lista para almacenar objetos Transporte
    private List<Transporte> transportes;

    // Constructor que inicializa la lista de transportes
    public RedTransporte() {
        this.transportes = new ArrayList<>();
    }

    // Método para leer transportes desde un fichero
    public void leerTransportes(String filePath) throws IOException {
        // Leer todas las líneas del fichero
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        // Iterar sobre cada línea, omitiendo la primera línea de cabecera
        for (String line : lines.subList(1, lines.size())) {
            // Dividir la línea en datos separados por ";"
            String[] data = line.split(";");
            String codigo = data[0];
            String tipo = data[1];
            String linea = data[2];
            // Convertir "S" o "N" a booleano para el conductor
            boolean tieneConductor = data[3].equalsIgnoreCase("S");
            int mediaPasajerosDia = Integer.parseInt(data[4]);
            int maximoPasajerosHora = Integer.parseInt(data[5]);

            // Crear un objeto Transporte y añadirlo a la lista
            Transporte transporte = new Transporte(codigo, tipo, linea, tieneConductor, mediaPasajerosDia, maximoPasajerosHora);
            transportes.add(transporte);
        }
    }

    // Método para escribir un reporte de los transportes con más viajeros
    public void escribirReporteTransportes(String filePath) throws IOException {
        // Comprobar si la lista de transportes está vacía
        if (transportes.isEmpty()) {
            System.out.println("No hay datos de transportes para analizar.");
            return;
        }

        // Encontrar el transporte con más pasajeros al día
        Transporte topDia = Collections.max(transportes, Comparator.comparingInt(Transporte::getMediaPasajerosDia));
        // Encontrar el transporte con más pasajeros por hora
        Transporte topHora = Collections.max(transportes, Comparator.comparingInt(Transporte::getMaximoPasajerosHora));

        // Escribir los resultados en el fichero
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            writer.write("Reporte Top Transportes a fecha " + java.time.LocalDateTime.now() + ";\n");
            writer.write(String.format("Transporte top dia;%s;%s;%s;%s;%d;\n",
                topDia.getCodigo(), topDia.getTipo(), topDia.getLinea(), 
                topDia.isTieneConductor() ? "conductor" : "sin conductor", 
                topDia.getMediaPasajerosDia()));
            writer.write(String.format("Transporte top hora;%s;%s;%s;%s;%d;\n",
                topHora.getCodigo(), topHora.getTipo(), topHora.getLinea(), 
                topHora.isTieneConductor() ? "conductor" : "sin conductor", 
                topHora.getMaximoPasajerosHora()));
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Crear una instancia de RedTransporte
        RedTransporte redTransporte = new RedTransporte();

        try {
            // Leer los datos de transportes desde el fichero
            redTransporte.leerTransportes("publicTransportData.txt");
            // Escribir el reporte en el fichero
            redTransporte.escribirReporteTransportes("topTransportes.txt");
            System.out.println("Reporte generado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}