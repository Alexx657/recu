package uf3;
public class Transporte {
    // Atributos de la clase Transporte
    private String codigo;                // Código del transporte
    private String tipo;                  // Tipo de transporte (Tren, Bus, Metro)
    private String linea;                 // Línea del transporte
    private boolean tieneConductor;       // Si el transporte tiene conductor o no
    private int mediaPasajerosDia;        // Media de pasajeros al día
    private int maximoPasajerosHora;      // Máximo de pasajeros por hora

    // Constructor para inicializar los atributos
    public Transporte(String codigo, String tipo, String linea, boolean tieneConductor, int mediaPasajerosDia, int maximoPasajerosHora) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.linea = linea;
        this.tieneConductor = tieneConductor;
        this.mediaPasajerosDia = mediaPasajerosDia;
        this.maximoPasajerosHora = maximoPasajerosHora;
    }

    // Métodos para obtener información (Getters)
    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLinea() {
        return linea;
    }

    public boolean isTieneConductor() {
        return tieneConductor;
    }

    public int getMediaPasajerosDia() {
        return mediaPasajerosDia;
    }

    public int getMaximoPasajerosHora() {
        return maximoPasajerosHora;
    }
}
