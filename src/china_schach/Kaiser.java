import greenfoot.Actor;


public final class Kaiser extends Spielfigur {

  public Kaiser(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-King-Red.png");
    } else {
      setImage("English-King-Black.png");
    }
  }

  public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
    Schnittpunkt ziel = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    if (ziel != null && istBewegungErlaubt(ziel) && istKeinVerbündeter(ziel)) {
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
    boolean result = false;
    if (ziel.getPunkttyp() == Punkttyp.FESTUNG
        && position.getPunkttyp() == Punkttyp.FESTUNG) {
      // Vertical movement
      if (Math.abs(position.getZeile() - ziel.getZeile()) == 1 &&
          Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 0) {
        result = true;
      }
      // Horizontal movement
      else if (position.getZeile() - ziel.getZeile() == 0 &&
          Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1) {
        result = true;
      }
    }
    return result;
  }
}

