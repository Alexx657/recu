package cartas;

public class Tropa extends Carta {
    private int nivelFuerza = 2;

    @Override
    public int getNivelAtaque() {
        return super.getNivelAtaque() * nivelFuerza;
    }
}

class Estructura extends Carta {
    private int nivelEscudo = 3;

    @Override
    public int getNivelDefensa() {
        return super.getNivelDefensa() * nivelEscudo;
    }
}

class Hechizo extends Carta {
    private int nivelMagia = 4;

    @Override
    public int getNivelAtaque() {
        return super.getNivelAtaque() + nivelMagia;
    }
}
