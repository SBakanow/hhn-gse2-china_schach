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
    if (ziel != null && istBewegungErlaubt(ziel) && istKeinVerbündeter(ziel) && istSpielfigurDazwischen(ziel, schnittpunkte) && kaiserPrüfung(ziel)) {
      setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
      schlagen(ziel);
      setPosition();
      return true;
    } else {
      setLocation(oldX, oldY);
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
    int difZ = ziel.getZeile() - position.getZeile();
    int difS = ziel.getSpalte() - position.getSpalte();

    if (Math.abs(difS) > Math.abs(difZ)) {
      //Vertical
      if (difS < 0) {
          if (schnittpunkte[position.getSpalte() - 1][position.getZeile()].getSpielfigur() != null) {
            return false;
          }
      } else {
          if (schnittpunkte[position.getSpalte() + 1][position.getZeile()].getSpielfigur() != null) {
            return false;
        }
      }
      //Horizontal
    } else {
      if (difZ < 0) {
          if (schnittpunkte[position.getSpalte()][position.getZeile() - 1].getSpielfigur() != null) {
            return false;
          }
      } else {
          if (schnittpunkte[position.getSpalte()][position.getZeile() + 1].getSpielfigur() != null) {
            return false;
          }
        }
    }
    return true;
  }
}

