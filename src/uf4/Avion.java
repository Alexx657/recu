package uf4;

public class Avion extends Vehiculo implements Aereo {
    String aeropuerto;

    //Si ponemos extends de algo , hay q poner los atributos de vehiculo en este caso mas el de avion 
    public Avion(String licencia, int combustible, boolean disponible, String aeropuerto) {
    	//ponemos en el supero los atributtos solo de la clase q extendemos
        super(licencia, combustible, disponible);
        this.aeropuerto = aeropuerto;
    }

    @Override
    public void cargar() {
        System.out.println("cargando en aeropuerto " + aeropuerto);
    }

    @Override
    public void volar() {
        System.out.println("volando");
        disponible = false;
        aeropuerto = null;
        combustible -= 30;
    }

    public void mostrarDatos() {
        System.out.println("Avion [licencia=" + licencia + ", combustible=" + combustible + ", disponible=" + disponible + ", aeropuerto=" + aeropuerto + "]");
    }
}
