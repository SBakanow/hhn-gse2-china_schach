
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
            setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
            oldX = getX();
            oldY = getY();
        } else {
            setLocation(oldX, oldY);
            oldX = getX();
            oldY = getY();
        }
    }


    private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
        if (ziel.getPunkttyp() == Punkttyp.FESTUNG &&
            position.getPunkttyp() == Punkttyp.FESTUNG) {
            // Vertical movement
            if (Math.abs(position.getZeile() - ziel.getZeile()) == 1 &&
                Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 0) {
                setPosition();
                position = ziel;
                return true;
            }
            // Horizontal movement
            else if(position.getZeile() - ziel.getZeile() == 0 &&
                    Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 1){
                setPosition();
                position = ziel;
                return true;
            }
        }

        return false;
    }
}

