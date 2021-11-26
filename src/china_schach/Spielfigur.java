import greenfoot.Actor;
import greenfoot.Greenfoot;

public abstract class Spielfigur extends Actor {

    protected final Farbe farbe;
    protected Schnittpunkt position;
    protected int oldX;
    protected int oldY;
    protected boolean geschlagen;
    protected static int geschlageneRoteSpieler;
    protected static int geschlageneSchwarzeSpieler;

    /**
     * @param farbe Gibt an, ob die Spielfigur rot ist oder nicht.
     */
    public Spielfigur(final Farbe farbe) {
        // TODO - implement Spielfigur.Spielfigur
        this.farbe = farbe;
    }
    
    public static void resetSpielfigurStatics() {
        geschlageneRoteSpieler = 0;
        geschlageneSchwarzeSpieler = 0;
    }
    
    public boolean istGeschlagen() {
        return geschlagen;
    }
    
    public void setIstGeschlagen(){
        geschlagen = false;
    }

    /**
     * @param schnittpunkte Ziel an dem die Spielfigur hin will.
     */
    public abstract boolean bewegen(Schnittpunkt[][] schnittpunkte);

    public Farbe getFarbe() {
        return farbe;
    }

    
    /**
     * Setze die Position der Spielfigur
     */
    public void setPosition() {
        if (position != null) {
            position.removeSpielfigur();
        }
        position = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
        position.setSpielfigur(this);
        oldX = getX();
        oldY = getY();
    }

    public boolean istKeinVerbündeter(Schnittpunkt ziel) {
        return (ziel.getSpielfigur() == null 
        || ziel.getSpielfigur().getFarbe() != farbe);
    }

    public void schlagen(Schnittpunkt ziel) {
        Spielfigur geschlagener = ziel.getSpielfigur();
        if (geschlagener != null) {
            int x = 0;
            int y = 0;
            if (ziel.getSpielfigur().farbe == Farbe.ROT) {
                x = (geschlageneRoteSpieler < 8) ? 100 : 180;
                y = (geschlageneRoteSpieler < 8) ? (geschlageneRoteSpieler * 75 + 235) : ((geschlageneRoteSpieler -8) * 75 + 235);
                geschlageneRoteSpieler++;
            } else {
                x = (geschlageneSchwarzeSpieler < 8) ? 1220 : 1300;
                y = (geschlageneSchwarzeSpieler < 8) ? (geschlageneSchwarzeSpieler * 75 + 235) : ((geschlageneSchwarzeSpieler -8) * 75 + 235);
                geschlageneSchwarzeSpieler++;
            }
            ziel.getSpielfigur().geschlagen = true;
            ziel.getSpielfigur().setLocation(x, y);
            Greenfoot.playSound("throw.mp3");
        }
    }
}

