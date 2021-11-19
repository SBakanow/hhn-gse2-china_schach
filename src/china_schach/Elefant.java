import greenfoot.*;
public class Elefant extends Spielfigur {
    int oldX;
    int oldY;
    public Elefant(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
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
        if(ziel != null) {
            setLocation(((Actor)ziel).getX(), ((Actor)ziel).getY());
            oldX = getX();
            oldY = getY();
        } else {
            setLocation(oldX, oldY);   
            oldX = getX();
            oldY = getY();
        }
    }
}