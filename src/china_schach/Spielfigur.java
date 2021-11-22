
import greenfoot.*;


public abstract class Spielfigur extends Actor {
    protected Schnittpunkt position;
    protected int oldX;
    protected int oldY;
    protected boolean geschlagen;
    protected final boolean farbeIstRot;

    /**
     * @param farbeIstRot Gibt an, ob die Spielfigur rot ist oder nicht.
     */
    public Spielfigur(final boolean farbeIstRot) {
        // TODO - implement Spielfigur.Spielfigur
        this.farbeIstRot = farbeIstRot;
    }
    
    /**
     * @param ziel Ziel an dem die Spielfigur hin will.
     */
    public abstract boolean bewegen();
    
    public abstract boolean iterateMoves(Schnittpunkt[][] schnittpunkte);
    
    public void test() {
        System.out.println("Test");
    }
    /**
     * Setze die Position der Spielfigur
     */
    public void setPosition() {
        if (position != null) {
            position.removeSpielfigur();
        }
        position = (Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class);
        position.setSpielfigur(this);
        oldX = getX();
        oldY = getY();
    }
    
    public void isLocationValid() {
        
    }
}
