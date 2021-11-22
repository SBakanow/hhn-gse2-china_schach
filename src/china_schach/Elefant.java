import greenfoot.*;


public final class Elefant extends Spielfigur {
  public Elefant(final boolean farbeIstRot) {
    super(farbeIstRot);

    if (farbeIstRot) {
      setImage("English-Elephant-Red.png");
    } else {
      setImage("English-Elephant-Black.png");
    }
  }

  public boolean bewegen() {
        Schnittpunkt ziel = (Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class);
        return istBewegungErlaubt(ziel);
        /*if (ziel != null && istBewegungErlaubt(ziel)) {
          setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
          oldX = getX();
          oldY = getY();
        } else {
          setLocation(oldX, oldY);
          oldX = getX();
          oldY = getY();
        }*/
    }


  private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
    boolean result = false;
    istSpielfigurDazwischen(ziel);
    if (position.getPunkttyp() == Punkttyp.FLUSS &&
        (position.getZeile() - ziel.getZeile() == -2) &&
        Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 &&
        farbeIstRot) {
      result = true;
    } else if (position.getPunkttyp() == Punkttyp.FLUSS &&
        (position.getZeile() - ziel.getZeile() == 2) &&
        Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 &&
        !farbeIstRot) {
      result = true;
    } else if (Math.abs(position.getZeile() - ziel.getZeile()) == 2 &&
        Math.abs(((int) position.getSpalte() - ziel.getSpalte())) == 2 &&
        position.getPunkttyp() != Punkttyp.FLUSS) {
      result = true;
    }
    
    if(ziel.getSpielfigur().farbeIstRot != farbeIstRot) {
        result = true;
    } else {
        result = false;
    }
    return result;
  }
  
    
  public boolean iterateMoves(Schnittpunkt[][] schnittpunkte) {
      boolean result = false;
      Schnittpunkt ziel = (Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class);
      int x = ((position.getZeile() - ziel.getZeile()) * -1)/2;
      int y = ((position.getSpalte() - ziel.getSpalte()) * -1)/2;
      if (schnittpunkte[ziel.getZeile() + x][ziel.getSpalte() + y].getSpielfigur() != null) {
          setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
          oldX = getX();
          oldY = getY();
        } else {
          setLocation(oldX, oldY);
      }
      
      return result;
  }
  private boolean istSpielfigurDazwischen(final Schnittpunkt ziel) {
      
      return false;
  }
}

