import greenfoot.*;
public class Bauer extends Spielfigur {
    
    int oldX;
    int oldY;
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
        if(ziel != null && istBewegungErlaubt(position, ziel)) {
            setLocation(((Actor)ziel).getX(), ((Actor)ziel).getY());
            oldX = getX();
            oldY = getY();
            setPosition();
        } else {
            setLocation(oldX, oldY);   
            oldX = getX();
            oldY = getY();
        }
    }
    
    public boolean istBewegungErlaubt(Schnittpunkt start, Schnittpunkt ziel) {
        if(farbeIstRot) {
            if(ziel.getZeile() <= 4) {
                if(Math.abs(start.getSpalte() - ziel.getSpalte()) == 1 && start.getZeile() - ziel.getZeile() == 0) {
                return true;
                }
            }   
            if(start.getZeile() - ziel.getZeile() == 1 && start.getSpalte() - ziel.getSpalte() == 0) {
                return true;
            }
        } else {
            if(ziel.getZeile() >= 5) {
                if(Math.abs(start.getSpalte() - ziel.getSpalte()) == 1 && start.getZeile() - ziel.getZeile() == 0) {
                return true;
                }
            }   
            if(start.getZeile() - ziel.getZeile() == -1 && start.getSpalte() - ziel.getSpalte() == 0) {
                return true;
            } 
        }
        return false;
    }

    public void setPosition() {
        oldX = getX();
        oldY = getY();
        position = (Schnittpunkt) getOneObjectAtOffset(0, 0, Schnittpunkt.class);
    }
}