import greenfoot.*;


public final class Turm extends Spielfigur {
    public Turm(final boolean farbeIstRot) {
        super(farbeIstRot);

        if (farbeIstRot) {
            setImage("images/English-Rook-Red.png");
        } else {
            setImage("images/English-Rook-Black.png");
        }
    }

    public boolean bewegen(Schnittpunkt[][] schnittpunkte) {
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

    private boolean istBewegungErlaubt(final Schnittpunkt ziel){
        if (position.getZeile() != ziel.getZeile() ^
            position.getSpalte() != ziel.getSpalte()) {
            setPosition();
            position = ziel;
            return true;
        }

        return false;
    }
}

