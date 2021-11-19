import greenfoot.*;
public class Spielbrett extends World {

    private Spieler[] dieSpieler;
    private Schnittpunkt[][] dieSchnittpunkte = new Schnittpunkt[9][10];
    final int offsetX = 50;
    final int offsetY = 50;
    final int scalingY = 100;
    final int scalingX = 100;

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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        for(int x = 0; x < 9; x++) {
            for (int y = 0; y < 10; y++) {
                addObject(dieSchnittpunkte[x][y], x*scalingX+offsetX, y*scalingY+offsetY);
            }
        }
        Bauer bauer2 = new Bauer(true);
        addObject(bauer2,649,647);
        bauer2.setLocation(649,647);
        bauer2.setPosition();
        Bauer bauer3 = new Bauer(false);
        addObject(bauer3,249,346);
        bauer3.setLocation(249,346);
        bauer3.setPosition();
    }

    /**
    * Initialisiere die Schnittpunkte
    */
    private void initSchnittpunkte() {
        for(int x = 0; x < 9; x++) {
            for (int y = 0; y < 10; y++) {
                if(y == 0 || y == 8) {
                    if(x >= 3 && x <= 5) {
                        dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.forDigit('a', 10)+x), y, true, Punkttyp.FESTUNG);
                    } else {
                        dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.forDigit('a', 10)+x), y, true, Punkttyp.NORMAL);
                    }
                } else if (y == 4 || y == 5 ) {
                    dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.forDigit('a', 10)+x), y, false, Punkttyp.FLUSS);
                } else if ((x >= 3 && x <= 5) && ((y <= 2) || (y >= 7))) {
                    dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.forDigit('a', 10)+x), y, false, Punkttyp.FESTUNG);
                } else {
                    dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.forDigit('a', 10)+x), y, false, Punkttyp.NORMAL);
                }
            }
        }
    }
}