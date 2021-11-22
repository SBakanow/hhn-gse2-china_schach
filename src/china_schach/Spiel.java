import greenfoot.*;

public final class Spiel extends Actor {
    
    private Spieler[] dieSpieler = new Spieler[2];
    private Spielbrett dasSpielbrett;
    private Spielfigur[] dieSpielfiguren = new Spielfigur[32];
    private Spielstand spielstand = Spielstand.UNKONFIGURIERT;
    private Spielfigur actor = null;
    
    public Spiel(Spielbrett spielbrett) {
        dasSpielbrett = spielbrett;
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
        if(Greenfoot.mousePressed(null)) {
            actor = (Spielfigur) Greenfoot.getMouseInfo().getActor();
        }
        if (actor != null) {
            if (Greenfoot.mouseDragged(null)) {
                ((Actor)actor).setLocation(Greenfoot.getMouseInfo().getX(),
                        Greenfoot.getMouseInfo().getY());
            }
            if (Greenfoot.mouseDragEnded(null)) {
                if(actor.bewegen())
                    actor.iterateMoves(dasSpielbrett.getSchnittpunkte());
            }
            // TODO - implement Spiel.starten
        }
    }

    public void beenden() {
        spielstand = Spielstand.BEENDET;
        // TODO - implement Spiel.beenden
        throw new UnsupportedOperationException();
    }
}

