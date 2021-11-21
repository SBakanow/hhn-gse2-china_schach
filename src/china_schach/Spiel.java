public class Spiel {

    private ChinaSchachKontrolle dieKontrollKlasse = new ChinaSchachKontrolle();
    private Spieler[] dieSpieler = new Spieler[2];
    private Spielbrett dasSpielbrett;
    private Spielfigur[] dieSpielfiguren = new Spielfigur[32];
    private Spielstand spielstand = Spielstand.UNKONFIGURIERT;

    public void konfiguriereSpiel() {
        // TODO - implement Spiel.konfiguriereSpiel
        
    }

    public void zurücksetzen() {
        // TODO - implement Spiel.zurücksetzen
        throw new UnsupportedOperationException();
    }

    public void starten() {
        // TODO - implement Spiel.starten
        System.out.println("Test the dragged function");
    }

    public void beenden() {
        // TODO - implement Spiel.beenden
        throw new UnsupportedOperationException();
    }

    public Spiel(Spielbrett dasSpielbrett) {
        // TODO - implement Spiel.Spiel
        this.dasSpielbrett = dasSpielbrett;
    }

}