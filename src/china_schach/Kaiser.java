
import greenfoot.*;


public final class Kaiser extends Spielfigur {
    public Kaiser(final boolean farbeIstRot) {
        super(farbeIstRot);

        if (farbeIstRot) {
            setImage("English-King-Red.png");
        } else {
            setImage("English-King-Black.png");
        }
    }

    public boolean bewegen() {
        Schnittpunkt ziel = (Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class);
        if (ziel != null && istBewegungErlaubt(ziel)) {
          setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
          oldX = getX();
          oldY = getY();
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
            if(ziel.getSpielfigur() != null && ziel.getSpielfigur().farbeIstRot == farbeIstRot) {
                return false;
            }
            if (Math.abs(position.getZeile() - ziel.getZeile()) == 1 &&
                Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 0) {
                setPosition();
                position = ziel;
                result = true;
            }
            // Horizontal movement
            else if(position.getZeile() - ziel.getZeile() == 0 &&
                    Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 1){
                setPosition();
                result = true;
            }
        }
        return result;
    }
      public boolean iterateMoves(Schnittpunkt[][] schnittpunkte) {
      return false;
  }
}

