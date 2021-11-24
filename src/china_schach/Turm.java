import greenfoot.Actor;


public final class Turm extends Spielfigur {

  public Turm(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-Rook-Red.png");
    } else {
      setImage("English-Rook-Black.png");
    }
  }

  public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
    Schnittpunkt ziel = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    if (ziel != null && istBewegungErlaubt(ziel) && istKeinVerbündeter(ziel) && istSpielfigurDazwischen(ziel, schnittpunkte)) {
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
    if (position.getZeile() != ziel.getZeile() ^
            position.getSpalte() != ziel.getSpalte()) {
      return true;
    }
    return false;
  }

  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    int dif = ziel.getZeile() - position.getZeile();
    if (dif == 0) {
      //Vertical
      dif = ziel.getSpalte() - position.getSpalte();
      if (dif < 0) {
        for (int i = 1; i < Math.abs(dif); i++) {
          if (schnittpunkte[position.getSpalte() - i][ziel.getZeile()].getSpielfigur() != null) {
            return false;
          }
        }
      } else {
        for (int i = 1; i < dif; i++) {
          if (schnittpunkte[position.getSpalte() + i][ziel.getZeile()].getSpielfigur() != null) {
            return false;
          }
        }
      }
      //Horizontal
    } else {
      if (dif < 0) {
        for (int i = 1; i < Math.abs(dif); i++) {
          if (schnittpunkte[ziel.getSpalte()][position.getZeile() - i].getSpielfigur() != null) {
            return false;
          }
        }
      } else {
        for (int i = 1; i < dif; i++) {
          if (schnittpunkte[ziel.getSpalte()][position.getZeile() + i].getSpielfigur() != null) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
