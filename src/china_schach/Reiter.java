import greenfoot.Actor;

public final class Reiter extends Spielfigur {

  public Reiter(final Farbe farbe) {
    super(farbe);
    if (farbe == Farbe.ROT) {
      setImage("English-Horse-Red.png");
    } else {
      setImage("English-Horse-Black.png");
    }
  }


  public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
    Schnittpunkt ziel = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    if (ziel != null && istBewegungErlaubt(ziel) && istKeinVerbündeter(ziel) && istSpielfigurDazwischen(ziel, schnittpunkte)) {
      setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
      setPosition();
      oldX = getX();
      oldY = getY();
      return true;
    } else {
      setLocation(oldX, oldY);
      oldX = getX();
      oldY = getY();
    }
    return false;
  }


  public boolean istBewegungErlaubt(final Schnittpunkt ziel) {
    boolean ergebnis = false;
    if ((Math.abs((int) position.getZeile() - ziel.getZeile()) == 2
        && Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1)
        || Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2
        && Math.abs((int) position.getZeile() - ziel.getZeile()) == 1) {
      ergebnis = true;
    }
    return ergebnis;
  }

  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    boolean result = false;

      //todo

    return !result;
  }
}

