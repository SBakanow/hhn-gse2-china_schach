public final class Spiel {
    // Da ChinaSchachKontrolle sich als Singleton anbietet brauchen wir keine Variable => Discuss
    //private final ChinaSchachKontrolle dieKontrollKlasse;
    private ChinaSchachKontrolle dieKontrollKlasse;
    private Spieler[] dieSpieler = new Spieler[2];
    private Spielbrett dasSpielbrett;
    private Spielfigur[] dieSpielfiguren = new Spielfigur[32];
    private Spielstand spielstand = Spielstand.UNKONFIGURIERT;
    public Spiel(Spielbrett spielbrett) {
        dieSpieler      = new Spieler[2];
        dasSpielbrett      = spielbrett;
        dieSpielfiguren = new Spielfigur[32];
        spielstand      = Spielstand.UNKONFIGURIERT;
        dieKontrollKlasse = ChinaSchachKontrolle.getInstance();
        // TODO - implement Spiel.Spiel
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

