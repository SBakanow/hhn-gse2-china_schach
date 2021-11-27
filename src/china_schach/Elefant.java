import greenfoot.Actor;
public final class Elefant extends Spielfigur {

  public Elefant(final Farbe farbe) {
    super(farbe);

    if (farbe == Farbe.ROT) {
      setImage("English-Elephant-Red.png");
    } else {
      setImage("English-Elephant-Black.png");
    }
  }

  public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
    boolean result = false;
    Schnittpunkt ziel = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    if (ziel != null && istBewegungErlaubt(ziel) 
    && istSpielfigurDazwischen(ziel, schnittpunkte) 
    && istKeinVerbündeter(ziel)
    && kaiserPrüfung(ziel)) {
        setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
        schlagen(ziel);
        setPosition();
        result = true;
    } else {
        setLocation(oldX, oldY);
    }
    return result;
  }

  private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
    boolean result = false;
    if (position.getPunkttyp() == Punkttyp.FLUSS &&
        position.getZeile() - ziel.getZeile() == -2 &&
        Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 &&
        farbe == Farbe.ROT) {
      result = true;
    } else if (position.getPunkttyp() == Punkttyp.FLUSS &&
        (position.getZeile() - ziel.getZeile() == 2) &&
        Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 &&
        farbe == Farbe.SCHWARZ) {
      result = true;
    } else if (Math.abs(position.getZeile() - ziel.getZeile()) == 2 &&
        Math.abs(((int) position.getSpalte() - ziel.getSpalte())) == 2 &&
        position.getPunkttyp() != Punkttyp.FLUSS) {
      result = true;
    }
    return result;
  }

  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel, final Schnittpunkt[][] schnittpunkte) {
    boolean result = false;
    int xPosition = (position.getSpalte() - ziel.getSpalte()) >> 1;
    int yPosition = (position.getZeile() - ziel.getZeile()) >> 1;
    if(schnittpunkte[ziel.getSpalte() + xPosition][ziel.getZeile() + yPosition].getSpielfigur() != null) {
        result = true;
    }
    return !result;
  }
}

