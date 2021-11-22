
import greenfoot.*;
public final class Geschütz extends Spielfigur {


    public Geschütz(final boolean farbeIstRot) {
        super(farbeIstRot);

        if (farbeIstRot) {
            setImage("images/English-Cannon-Red.png");
        } else {
            setImage("images/English-Cannon-Black.png");
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
    
      public boolean iterateMoves(Schnittpunkt[][] schnittpunkte) {
      return false;
    } 

    private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
        if (position.getZeile() != ziel.getZeile() ^
            position.getSpalte() != ziel.getSpalte()) {
            setPosition();
            position = ziel;
            return true;
        } else {
            // TODO
        }

        return false;
    }
}

