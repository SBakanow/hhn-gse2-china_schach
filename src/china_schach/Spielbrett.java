import greenfoot.*;

public class Spielbrett extends World {

    private Spieler[] dieSpieler;
    private Schnittpunkt[][] dieSchnittpunkte = new Schnittpunkt[9][10];

    /**
     * 
     * @param breite
     * @param höhe
     * @param zellenGröße
     */
    public Spielbrett() {
        super(900, 996, 1);
        initSchnittpunkte();
        prepare();
    }

    final int offsetX = 50;
    final int offsetY = 50;
    final int scalingY = 100;
    final int scalingX = 100;
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                addObject(dieSchnittpunkte[i][j], i*scalingX+offsetX, j*scalingY+offsetY);
            }
        }
        Bauer bauer = new Bauer(true);
        addObject(bauer,606,402);
        bauer.setLocation(546,445);
    }
    
    /**
     * Initialisiere die Schnittpunkte
     */
    private void initSchnittpunkte() {
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                dieSchnittpunkte[i][j] = new Schnittpunkt((char)(Character.forDigit('a', 10)+i), j, false, Punkttyp.NORMAL);
            }
        }
    }
}