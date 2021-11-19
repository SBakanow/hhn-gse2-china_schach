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
        oldX = getX();
        oldY = getY();
        if(Greenfoot.mouseDragged(this)) {
            setLocation(Greenfoot.getMouseInfo().getX(),
                        Greenfoot.getMouseInfo().getY());
            if(Greenfoot.mouseDragEnded(this)) {
                bewegen((Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class));
            }
        }
    }
    
    public void bewegen(Schnittpunkt ziel) {
        if(ziel == null) {
            setLocation(((Actor)ziel).getX(), ((Actor)ziel).getY());
        }
        else {
            setLocation(oldX, oldY);
        }
    }
}