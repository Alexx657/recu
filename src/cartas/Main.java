package cartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear cartas
        List<Carta> mazo = new ArrayList<>();
        mazo.add(new Tropa());
        mazo.add(new Tropa());
        mazo.add(new Estructura());
        mazo.add(new Estructura());
        mazo.add(new Hechizo());
        mazo.add(new Hechizo());

        // Barajar el mazo
        Collections.shuffle(mazo);

        // Crear jugadores
        List<Carta> cartasJugador1 = mazo.subList(0, 3);
        List<Carta> cartasJugador2 = mazo.subList(3, 6);

        Jugador jugador1 = new Jugador("jugador1", cartasJugador1);
        Jugador jugador2 = new Jugador("jugador2", cartasJugador2);

        // Jugador 1 ataca, Jugador 2 defiende
        int ataque1 = jugador1.atacar(cartasJugador1.get(0));
        int defensa1 = jugador2.defender(cartasJugador2.get(0));
        int diferencia1 = ataque1 - defensa1;
        if (diferencia1 > 0) {
            jugador2.reducirVida(diferencia1);
        }

        // Jugador 2 ataca, Jugador 1 defiende
        int ataque2 = jugador2.atacar(cartasJugador2.get(1));
        int defensa2 = jugador1.defender(cartasJugador1.get(1));
        int diferencia2 = ataque2 - defensa2;
        if (diferencia2 > 0) {
            jugador1.reducirVida(diferencia2);
        }

        // Mostrar resultados
        System.out.println("Vida de jugador1: " + jugador1.getNivelVida());
        System.out.println("Vida de jugador2: " + jugador2.getNivelVida());

        // Determinar el ganador
        if (jugador1.getNivelVida() > jugador2.getNivelVida()) {
            System.out.println("El ganador es jugador1");
        } else if (jugador2.getNivelVida() > jugador1.getNivelVida()) {
            System.out.println("El ganador es jugador2");
        } else {
            System.out.println("Es un empate");
        }
    }
}

