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
        super(820, 920, 1);
        initSchnittpunkte();
        prepare();
    }


    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                addObject(dieSchnittpunkte[i][j], i*100+10, j*100+10);
            }
        }
        Bauer bauer = new Bauer(true);
        addObject(bauer,606,402);
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