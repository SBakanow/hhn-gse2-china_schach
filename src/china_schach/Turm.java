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

    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            setLocation(Greenfoot.getMouseInfo().getX(),
                        Greenfoot.getMouseInfo().getY());
        }
        if (Greenfoot.mouseDragEnded(this)) {
            bewegen((Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class));
        }
    }

    public void bewegen(final Schnittpunkt ziel) {
        if (ziel != null && istBewegungErlaubt(ziel)) {
            setLocation(((Actor)ziel).getX(), ((Actor)ziel).getY());
            oldX = getX();
            oldY = getY();
        } else {
            setLocation(oldX, oldY);
            oldX = getX();
            oldY = getY();
        }
    }


    private boolean istBewegungErlaubt(final Schnittpunkt ziel){
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

