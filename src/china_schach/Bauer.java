import greenfoot.Actor;

public final class Bauer extends Spielfigur {

  public Bauer(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-Pawn-Red.png");
    } else {
      setImage("English-Pawn-Black.png");
    }
  }

  public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
    Schnittpunkt ziel = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    if (ziel != null && istBewegungErlaubt(ziel) && istKeinVerbündeter(ziel)) {
      setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
      schlagen(ziel);
      setPosition();
      oldX = getX();
      oldY = getY();
      return true;
    } else {
      setLocation(oldX, oldY);
    }
    return false;
  }

  private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
    if (farbe == Farbe.ROT) {
      if (ziel.getZeile() <= 4) {
        if (Math.abs(position.getSpalte() - ziel.getSpalte()) == 1 &&
                position.getZeile() == ziel.getZeile()) {
          return true;
        }
      }
      if (position.getZeile() - ziel.getZeile() == 1 &&
              position.getSpalte() == ziel.getSpalte()) {
        return true;
      }
    } else if (farbe == Farbe.SCHWARZ) {
      if (ziel.getZeile() >= 5) {
        if (Math.abs(position.getSpalte() - ziel.getSpalte()) == 1 &&
                position.getZeile() == ziel.getZeile()) {
          return true;
        }
      }
      if (position.getZeile() - ziel.getZeile() == -1 &&
              position.getSpalte() == ziel.getSpalte()) {
        return true;
      }
    }

    return false;
  }
}