import greenfoot.Actor;


public final class Turm extends Spielfigur {

  public Turm(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-King-Red.png");
    } else {
      setImage("English-King-Black.png");
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

  private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
    if (position.getZeile() != ziel.getZeile() ^
        position.getSpalte() != ziel.getSpalte()) {
      return true;
    }
    return false;
  }

  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    boolean result = false;

      // todo

    return !result;
  }
}

