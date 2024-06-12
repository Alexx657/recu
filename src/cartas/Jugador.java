package cartas;

import java.util.List;

public class Jugador implements Batalla {
	private String nombre;
	private int nivelVida = 100;
	private List<Carta> cartas;

	public Jugador(String nombre, List<Carta> cartas) {
		this.nombre = nombre;
		this.cartas = cartas;
	}

	public int getNivelVida() {
		return nivelVida;
	}

	public void reducirVida(int cantidad) {
		this.nivelVida -= cantidad;
	}

	public int atacar(Carta carta) {
		return carta.getNivelAtaque();
	}

	public int defender(Carta carta) {
		return carta.getNivelDefensa();
	}
}
