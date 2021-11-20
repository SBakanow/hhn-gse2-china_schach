import greenfoot.*;
public class Turm extends Spielfigur {


    public Turm(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("images/English-Rook-Red.png");
        else
            setImage("images/English-Rook-Black.png");
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
        if(ziel != null && validMove(ziel)) {
            setLocation(((Actor)ziel).getX(), ((Actor)ziel).getY());
            oldX = getX();
            oldY = getY();
        } else {
            setLocation(oldX, oldY);
            oldX = getX();
            oldY = getY();
        }
    }
    public boolean validMove(Schnittpunkt ziel){
        boolean move = false;
        if (position.getZeile() != ziel.getZeile() ^ position.getSpalte() != ziel.getSpalte()){
            setPosition();
            position=ziel;
            move = true;
        }else{

        }
        return move;
    }
}
