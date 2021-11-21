
public final class Spiel {
    // Da ChinaSchachKontrolle sich als Singleton anbietet brauchen wir keine Variable => Discuss
	//private final ChinaSchachKontrolle dieKontrollKlasse;
	private final Spieler[] dieSpieler;
	private final Spielbrett dasSpielbrett;
	private final Spielfigur[] dieSpielfiguren;
	private final Spielstand spielstand;

    public Spiel() {
        dieSpieler      = new Spieler[2];
        spielbrett      = new Spielbrett();
        dieSpielfiguren = new Spielfiguren[32];
        spielstand      = Spielstand.UNKONFIGURIERT;
		// TODO - implement Spiel.Spiel
		throw new UnsupportedOperationException();
	}

	public void konfiguriereSpiel() {
        spielstand = Spielstand.KONFIGURIERT;
		// TODO - implement Spiel.konfiguriereSpiel
		throw new UnsupportedOperationException();
	}

	public void zurücksetzen() {
		// TODO - implement Spiel.zurücksetzen
		throw new UnsupportedOperationException();
	}

	public void starten() {
        spielstand = Spielstand.LAUFEND;
		// TODO - implement Spiel.starten
		throw new UnsupportedOperationException();
	}

	public void beenden() {
        spielstand = Spielstand.BEENDET;
		// TODO - implement Spiel.beenden
		throw new UnsupportedOperationException();
	}
}

