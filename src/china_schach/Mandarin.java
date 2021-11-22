
import greenfoot.*;


public final class Mandarin extends Spielfigur {
    public Mandarin(final boolean farbeIstRot) {
        super(farbeIstRot);

        if (farbeIstRot) {
            setImage("English-Advisor-Red.png");
        } else {
            setImage("English-Advisor-Black.png");
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
        if (ziel.getPunkttyp() == Punkttyp.FESTUNG &&
            position.getPunkttyp() == Punkttyp.FESTUNG) {
            //Right Up&Down
            if (position.getZeile() - ziel.getZeile() == 1 &&
                Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 1) {
                setPosition();
                return true;
            }
            //Left Up&Down
            else if (position.getZeile() - ziel.getZeile() == -1 &&
                     Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 1) {
                setPosition();
                return true;
            }
        }

        return false;
    }
    
      public boolean iterateMoves(Schnittpunkt[][] schnittpunkte) {
      return false;
  }
}

