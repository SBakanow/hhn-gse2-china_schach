import greenfoot.Actor;
import greenfoot.Greenfoot;

public final class Spiel extends Actor {


  private Spieler[] dieSpieler = new Spieler[2];
  private Spielbrett dasSpielbrett;
  private Spielfigur[] dieSpielfiguren = new Spielfigur[32];
  private Spielstand spielstand = Spielstand.UNKONFIGURIERT;
  private Spielfigur actor = null;
  private Farbe farbe = Farbe.ROT;
  private ChinaSchachKontrolle kontrolle = null;


  public Spiel(Spielbrett spielbrett) {
    dasSpielbrett = spielbrett;
    kontrolle = ChinaSchachKontrolle.getInstance();
  }

  public boolean starten() {
        spielstand = Spielstand.LAUFEND;
        if (Greenfoot.mousePressed(null)) {
          if (Greenfoot.getMouseInfo().getActor() instanceof Spielfigur) {
            actor = (Spielfigur) Greenfoot.getMouseInfo().getActor();
          }
        }
        if (actor != null) {
          if (!actor.geschlagen) {
            if (Greenfoot.mouseDragged(null) && actor.getFarbe() == farbe) {
              //System.out.println(actor.geschlagen);
              ((Actor) actor).setLocation(Greenfoot.getMouseInfo().getX(),
                  Greenfoot.getMouseInfo().getY());
            }
            if (Greenfoot.mouseDragEnded(null) && actor.getFarbe() == farbe) {
              if (actor.bewegen(dasSpielbrett.getSchnittpunkte())) {
                farbe = Farbe.ROT == farbe ? Farbe.SCHWARZ : Farbe.ROT;
                Greenfoot.playSound("click.mp3");
                actor = null;
              }
            }
          }
        }
        return ChinaSchachKontrolle.getInstance().prüfeMatt();
  }

  public Spielfigur[] getSpielfiguren() {
    return dieSpielfiguren;
  }
  
  public Schnittpunkt[][] getSchnittpunkte() {
      return dasSpielbrett.getSchnittpunkte();
  }

  public void konfiguriereSpiel() {
    spielstand = Spielstand.KONFIGURIERT;
    // TODO - implement Spiel.konfiguriereSpiel
    Spielfigur.resetSpielfigurStatics();
    for (int i = 0; i < 5; i++) {
      dieSpielfiguren[i] = new Bauer(Farbe.ROT);
      dasSpielbrett.addObject(dieSpielfiguren[i], 300 + (200 * i), 650);
      dieSpielfiguren[i + 5] = new Bauer(Farbe.SCHWARZ);
      dasSpielbrett.addObject(dieSpielfiguren[i + 5], 300 + (200 * i), 350);
    }

    for (int i = 10; i < 12; i++) {
      dieSpielfiguren[i] = new Elefant(Farbe.ROT);
      dasSpielbrett.addObject(dieSpielfiguren[i], 500 + (400 * (i - 10)), 950);
      dieSpielfiguren[i + 2] = new Elefant(Farbe.SCHWARZ);
      dasSpielbrett.addObject(dieSpielfiguren[i + 2], 500 + (400 * (i - 10)), 50);
      dieSpielfiguren[i + 4] = new Turm(Farbe.SCHWARZ);
      dasSpielbrett.addObject(dieSpielfiguren[i + 4], 300 + (800 * (i - 10)), 50);
      dieSpielfiguren[i + 6] = new Turm(Farbe.ROT);
      dasSpielbrett.addObject(dieSpielfiguren[i + 6], 300 + (800 * (i - 10)), 950);
      dieSpielfiguren[i + 8] = new Mandarin(Farbe.SCHWARZ);
      dasSpielbrett.addObject(dieSpielfiguren[i + 8], 600 + (200 * (i - 10)), 50);
      dieSpielfiguren[i + 10] = new Mandarin(Farbe.ROT);
      dasSpielbrett.addObject(dieSpielfiguren[i + 10], 600 + (200 * (i - 10)), 950);
      dieSpielfiguren[i + 12] = new Reiter(Farbe.SCHWARZ);
      dasSpielbrett.addObject(dieSpielfiguren[i + 12], 400 + (600 * (i - 10)), 50);
      dieSpielfiguren[i + 14] = new Reiter(Farbe.ROT);
      dasSpielbrett.addObject(dieSpielfiguren[i + 14], 400 + (600 * (i - 10)), 950);
      dieSpielfiguren[i + 16] = new Geschütz(Farbe.SCHWARZ);
      dasSpielbrett.addObject(dieSpielfiguren[i + 16], 400 + (600 * (i - 10)), 250);
      dieSpielfiguren[i + 18] = new Geschütz(Farbe.ROT);
      dasSpielbrett.addObject(dieSpielfiguren[i + 18], 400 + (600 * (i - 10)), 750);
    }

    dieSpielfiguren[30] = new Kaiser(Farbe.ROT);
    dasSpielbrett.addObject(dieSpielfiguren[30], 700, 950);
    dieSpielfiguren[31] = new Kaiser(Farbe.SCHWARZ);
    dasSpielbrett.addObject(dieSpielfiguren[31], 700, 50);

    for (var spielfigur : dieSpielfiguren) {
      spielfigur.setPosition();
      spielfigur.setIstGeschlagen();
    }
    
    kontrolle.setSpiel(this);
  }

  public void zurücksetzen() {
    // TODO - implement Spiel.zurücksetzen
    throw new UnsupportedOperationException();
  }

  public void beenden() {
    spielstand = Spielstand.BEENDET;
    // TODO - implement Spiel.beenden
  }
}

