import greenfoot.*;
public class Elefant extends Spielfigur {
    
    public Elefant(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("English-Elephant-Red.png");
        else
            setImage("English-Elephant-Black.png");
    }

    public void act() {
        if(Greenfoot.mouseDragged(this)) {
            setLocation(Greenfoot.getMouseInfo().getX(),
                Greenfoot.getMouseInfo().getY());
        }
        if(Greenfoot.mouseDragEnded(this)) {
            bewegen((Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class));
        }
    }

    public void bewegen(Schnittpunkt ziel) {
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

    public boolean istBewegungErlaubt(Schnittpunkt ziel) {
        boolean result = false;
        if (position.getPunkttyp() == Punkttyp.FLUSS
        && (position.getZeile() - ziel.getZeile() == -2)
        && Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 2
        && farbeIstRot) {
            setPosition();
            result = true;
            position = ziel;
        } else if (position.getPunkttyp() == Punkttyp.FLUSS
        && (position.getZeile() - ziel.getZeile() == 2)
        && Math.abs((int)position.getSpalte() - ziel.getSpalte()) == 2
        && !farbeIstRot) {
            setPosition();
            result = true;
            position = ziel;
        } else if (Math.abs(position.getZeile() - ziel.getZeile()) == 2 
        &&  Math.abs(((int)position.getSpalte() - ziel.getSpalte())) == 2
        && position.getPunkttyp() != Punkttyp.FLUSS) {
            setPosition();
            result = true;
            position = ziel;
        }
        return result;
    }
}
