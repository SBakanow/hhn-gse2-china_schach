import greenfoot.Actor;

public final class Geschütz extends Spielfigur {


  public Geschütz(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-Cannon-Red.png");
    } else {
      setImage("English-Cannon-Black.png");
    }
  }

  public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
    Schnittpunkt ziel = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    if (ziel != null && istBewegungErlaubt(ziel, schnittpunkte)) {
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

  private boolean istBewegungErlaubt(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkt) {
    if ((position.getZeile() != ziel.getZeile() ^ position.getSpalte() != ziel.getSpalte())
            && !istSpielfigurDazwischen(ziel, schnittpunkt) && istKeinVerbündeter(ziel)) {
      return true;
    } else return (position.getZeile() != ziel.getZeile() ^ position.getSpalte() != ziel.getSpalte())
              && (ziel.getSpielfigur() != null && istKeinVerbündeter(ziel)) && istSpielfigurDazwischen(ziel, schnittpunkt);
  }

  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    boolean result = false;

       // todo

    return result;
  }
}

