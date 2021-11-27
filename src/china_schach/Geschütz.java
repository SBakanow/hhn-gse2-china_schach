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
    if (ziel != null && istBewegungErlaubt(ziel, schnittpunkte) && kaiserPrüfung(ziel)) {
      setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
      schlagen(ziel);
      setPosition();
      return true;
    } else {
      setLocation(oldX, oldY);
    }
    return false;
  }

  private boolean istBewegungErlaubt(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkt) {
    if ((position.getZeile() == ziel.getZeile() ^ position.getSpalte() == ziel.getSpalte())
            && !istSpielfigurDazwischen(ziel, schnittpunkt) && ziel.getSpielfigur() == null) {
      return true;
    } else {
      return (position.getZeile() != ziel.getZeile() ^ position.getSpalte() != ziel.getSpalte())
            && (ziel.getSpielfigur() != null && istKeinVerbündeter(ziel)) && istSpielfigurDazwischen(ziel, schnittpunkt);
    }
  }

  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    int dif = ziel.getZeile() - position.getZeile();
    if (dif == 0) {
      //Vertical
      dif = ziel.getSpalte() - position.getSpalte();
      for (int i = 1; i < Math.abs(dif); i++) {
        if (dif < 0 && schnittpunkte[position.getSpalte() - i][ziel.getZeile()].getSpielfigur() != null) {
            return true;
        } else if(dif > 0 && schnittpunkte[position.getSpalte() + i][ziel.getZeile()].getSpielfigur() != null) {
            return true;
        }
      }
      //Horizontal
    } else {
      for (int i = 1; i < Math.abs(dif); i++) {
        if (dif < 0 && schnittpunkte[ziel.getSpalte()][position.getZeile() - i].getSpielfigur() != null) {
          return true;
        } else if (dif > 0 && schnittpunkte[ziel.getSpalte()][position.getZeile() + i].getSpielfigur() != null) {
          return true;
        }
      }
    }
    return false;
  }
}
