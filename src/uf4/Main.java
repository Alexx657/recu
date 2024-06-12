package uf4;

public class Main {
	public static void main(String[] args) {
		Barco barco = new Barco("111", 50, true, "Valencia");
		Avion avion = new Avion("222", 200, true, "Palma");

		barco.cargar();
		barco.navegar();

		avion.cargar();
		avion.volar();
		barco.mostrarDatos();
	    avion.mostrarDatos();
	}
}
