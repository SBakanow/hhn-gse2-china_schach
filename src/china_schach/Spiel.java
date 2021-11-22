import greenfoot.Actor;
import greenfoot.Greenfoot;

public final class Spiel extends Actor {


  private Spieler[] dieSpieler = new Spieler[2];
  private Spielbrett dasSpielbrett;
  private Spielfigur[] dieSpielfiguren = new Spielfigur[32];
  private Spielstand spielstand = Spielstand.UNKONFIGURIERT;
  private Spielfigur actor = null;

  private Farbe farbe = Farbe.ROT;


  public Spiel(Spielbrett spielbrett) {
    dasSpielbrett = spielbrett;
  }

  public void starten() {
    spielstand = Spielstand.LAUFEND;
    if (Greenfoot.mousePressed(null)) {
      actor = (Spielfigur) Greenfoot.getMouseInfo().getActor();
    }
    if (actor != null) {
      if (Greenfoot.mouseDragged(null) && actor.getFarbe() == farbe) {
        ((Actor) actor).setLocation(Greenfoot.getMouseInfo().getX(),
            Greenfoot.getMouseInfo().getY());
      }
      if (Greenfoot.mouseDragEnded(null) && actor.getFarbe() == farbe) {
        if(actor.bewegen(dasSpielbrett.getSchnittpunkte())) {
            farbe = Farbe.ROT == farbe ? Farbe.SCHWARZ : Farbe.ROT;
        }
      }
    }
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

  public void beenden() {
    spielstand = Spielstand.BEENDET;
    // TODO - implement Spiel.beenden
    throw new UnsupportedOperationException();
  }
}

