import greenfoot.*;

public final class Reiter extends Spielfigur {
    public Reiter(final boolean farbeIstRot) {
        super(farbeIstRot);

        if (farbeIstRot) {
            setImage("images/English-Horse-Red.png");
        } else {
            setImage("images/English-Horse-Black.png");
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


    public boolean istBewegungErlaubt(final Schnittpunkt ziel) {
        boolean ergebnis = false;
            if ((Math.abs((int) position.getZeile() - ziel.getZeile()) == 2 && Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1) 
                || Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 && Math.abs((int) position.getZeile() - ziel.getZeile()) == 1) 
            {
                setPosition();
                ergebnis = true;
            }
        return ergebnis;    
    }
}

