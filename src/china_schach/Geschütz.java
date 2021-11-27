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
            && SpielfigurenDazwischen(ziel, schnittpunkt) == 0 && ziel.getSpielfigur() == null) {
      return true;
    } else {
      return (position.getZeile() != ziel.getZeile() ^ position.getSpalte() != ziel.getSpalte())
            && (ziel.getSpielfigur() != null && istKeinVerbündeter(ziel)) && SpielfigurenDazwischen(ziel, schnittpunkt) == 1;
    }
  }

  private int SpielfigurenDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    int dif = ziel.getZeile() - position.getZeile();
    int figurenAnzahl = 0;
    if (dif == 0) {
      //Vertical
      dif = ziel.getSpalte() - position.getSpalte();
      for (int i = 1; i < Math.abs(dif); i++) {
        if (dif < 0 && schnittpunkte[position.getSpalte() - i][ziel.getZeile()].getSpielfigur() != null) {
          figurenAnzahl++;
        } else if(dif > 0 && schnittpunkte[position.getSpalte() + i][ziel.getZeile()].getSpielfigur() != null) {
          figurenAnzahl++;
        }
      }
      //Horizontal
    } else {
      for (int i = 1; i < Math.abs(dif); i++) {
        if (dif < 0 && schnittpunkte[ziel.getSpalte()][position.getZeile() - i].getSpielfigur() != null) {
          figurenAnzahl++;
        } else if (dif > 0 && schnittpunkte[ziel.getSpalte()][position.getZeile() + i].getSpielfigur() != null) {
          figurenAnzahl++;
        }
      }
    }
    return figurenAnzahl;
  }
}
