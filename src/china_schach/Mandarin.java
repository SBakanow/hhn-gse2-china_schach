import greenfoot.*;
public class Mandarin extends Spielfigur {

    public Mandarin(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("English-Advisor-Red.png");
        else
            setImage("English-Advisor-Black.png");
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
        if (ziel.getPunkttyp() == Punkttyp.FESTUNG && position.getPunkttyp() == Punkttyp.FESTUNG){

            //Right Up&Down
            if(position.getZeile() - ziel.getZeile() == 1
                    && Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1){
                setPosition();
                position = ziel;
                return true;}

            //Left Up&Down
            else if(position.getZeile() - ziel.getZeile() == -1
                    && Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 1){
                setPosition();
                position = ziel;
                return true;}
        }
        return false;
    }
}