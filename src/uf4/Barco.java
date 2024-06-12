package uf4;

class Barco extends Vehiculo implements Navegable {
    String puerto;

    public Barco(String licencia, int combustible, boolean disponible, String puerto) {
        super(licencia, combustible, disponible);
        this.puerto = puerto;
    }

    @Override
    public void cargar() {
        System.out.println("cargando en puerto " + puerto);
    }

    @Override
    public void navegar() {
        System.out.println("navegando");
        disponible = false;
        puerto = null;
        combustible -= 10;
    }

	@Override
	public void mostrarDatos() {
        System.out.println("Barco [licencia=" + licencia + ", combustible=" + combustible + ", disponible=" + disponible + ", puerto=" + puerto + "]");		
	}
}