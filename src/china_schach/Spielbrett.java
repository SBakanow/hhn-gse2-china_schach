import greenfoot.*;

public class Spielbrett extends World {

    private Spieler[] dieSpieler;
    private Schnittpunkt[] dieSchnittpunkte;

    /**
     * 
     * @param breite
     * @param höhe
     * @param zellenGröße
     */
    public Spielbrett() {
        super(80, 80, 8);
    }

}