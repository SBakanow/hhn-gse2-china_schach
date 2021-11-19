import greenfoot.*;

public abstract class Spielfigur extends Actor {

    protected Spieler besitzer;
    protected Schnittpunkt position;
    protected boolean farbeIstRot;
    protected boolean geschlagen;
    
    protected int oldX;
    protected int oldY;

    /**
     * 
     * @param ziel
     */
    public abstract void bewegen(Schnittpunkt ziel);

    /**
     * 
     * @param farbeIstRot
     */
    public Spielfigur(boolean farbeIstRot) {
        // TODO - implement Spielfigur.Spielfigur
        this.farbeIstRot = farbeIstRot;
    }
    
    /**
     * Setze die Position der Spielfigur
     */
    public void setPosition() {
        oldX = getX();
        oldY = getY();
        if(position != null)
            position.removeSpielfigur();
        position = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
        position.setSpielfigur(this);
    }
}