package uf4;

public abstract class Vehiculo {
    String licencia;
    int combustible;
    boolean disponible;

    public Vehiculo(String licencia, int combustible, boolean disponible) {
        this.licencia = licencia;
        this.combustible = combustible;
        this.disponible = disponible;
    }

    public void cargar() {
        System.out.println("cargando");
    }

    public abstract void mostrarDatos();
}
