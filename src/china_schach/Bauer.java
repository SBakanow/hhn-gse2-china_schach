import greenfoot.*;
public class Bauer extends Spielfigur { 
    public Bauer(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("English-Pawn-Red.png");
        else
            setImage("English-Pawn-Black.png");
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
        if(ziel != null && istBewegungErlaubt(ziel)) {
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
        boolean ergebnis = false;
        if(farbeIstRot) {
            if(ziel.getZeile() <= 4) {
                if(Math.abs(position.getSpalte() - ziel.getSpalte()) == 1 && position.getZeile() == ziel.getZeile()) {
                setPosition();
                ergebnis = true;
                position = ziel;
                }
            }   
            if(position.getZeile() - ziel.getZeile() == 1 && position.getSpalte() == ziel.getSpalte()) {
                setPosition();
                ergebnis = true;
                position = ziel;
            }
        } else {
            if(ziel.getZeile() >= 5) {
                if(Math.abs(position.getSpalte() - ziel.getSpalte()) == 1 && position.getZeile() == ziel.getZeile()) {
                setPosition();
                ergebnis = true;
                position = ziel;
                }
            }   
            if(position.getZeile() - ziel.getZeile() == -1 && position.getSpalte() == ziel.getSpalte()) {
                setPosition();
                ergebnis = true;
                position = ziel;
            } 
        }
        return ergebnis;
    }
}