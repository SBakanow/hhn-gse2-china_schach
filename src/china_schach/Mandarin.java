import greenfoot.Actor;

public final class Mandarin extends Spielfigur {

  public Mandarin(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-Advisor-Red.png");
    } else {
      setImage("English-Advisor-Black.png");
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
    if (ziel.getPunkttyp() == Punkttyp.FESTUNG &&
        position.getPunkttyp() == Punkttyp.FESTUNG) {
      //Right Up&Down
      if (position.getZeile() - ziel.getZeile() == 1 &&
          Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1) {
        return true;
      }
      //Left Up&Down
      else if (position.getZeile() - ziel.getZeile() == -1 &&
          Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1) {
        return true;
      }
    }
    return false;
  }
}

