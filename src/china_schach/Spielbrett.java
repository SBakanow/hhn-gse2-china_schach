import greenfoot.*;
public class Spielbrett extends World {

    private Spieler[] dieSpieler;
    private Schnittpunkt[][] dieSchnittpunkte = new Schnittpunkt[9][10];
    final int offsetX = 50;
    final int offsetY = 47;
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
        bauer2.setPosition();
        Bauer bauer3 = new Bauer(false);
        addObject(bauer3,249,346);
        bauer3.setPosition();
        Elefant elefant = new Elefant(true);
        addObject(elefant,243,947);
        elefant.setPosition();
        Elefant elefant2 = new Elefant(false);
        addObject(elefant2,652,48);
        elefant2.setPosition();
        
        Turm turmLR = new Turm(false);
        addObject(turmLR,50,50);
        turmLR.setPosition();
        Turm turmRR = new Turm(false);
        addObject(turmRR,850,50);
        turmRR.setPosition();
        Turm turmLB = new Turm(true);
        addObject(turmLB,50,950);
        turmLB.setPosition();
        Turm turmRB = new Turm(true);
        addObject(turmRB,850,950);
        turmRB.setPosition();

        Kaiser kaiser = new Kaiser(true);
        addObject(kaiser,450,947);
        kaiser.setPosition();
        Kaiser kaiser2 = new Kaiser(false);
        addObject(kaiser2,450,48);
        kaiser2.setPosition();

        Mandarin mandarin = new Mandarin(true);
        addObject(mandarin,350,947);
        mandarin.setPosition();
        Mandarin mandarin2 = new Mandarin(true);
        addObject(mandarin2,550,947);
        mandarin2.setPosition();
        Mandarin mandarin3 = new Mandarin(false);
        addObject(mandarin3,350,48);
        mandarin3.setPosition();
        Mandarin mandarin4 = new Mandarin(false);
        addObject(mandarin4,550,48);
        mandarin4.setPosition();
    }

    /**
    * Initialisiere die Schnittpunkte
    */
    private void initSchnittpunkte() {
        for(int x = 0; x < 9; x++) {
            for (int y = 0; y < 10; y++) {
                if(y == 0 || y == 8) {
                    if(x >= 3 && x <= 5) {
                        dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.getNumericValue('a')+x), y, true, Punkttyp.FESTUNG);
                    } else {
                        dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.getNumericValue('a')+x), y, true, Punkttyp.NORMAL);
                    }
                } else if (y == 4 || y == 5 ) {
                    dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.getNumericValue('a')+x), y, false, Punkttyp.FLUSS);
                } else if ((x >= 3 && x <= 5) && ((y <= 2) || (y >= 7))) {
                    dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.getNumericValue('a')+x), y, false, Punkttyp.FESTUNG);
                } else {
                    dieSchnittpunkte[x][y] = new Schnittpunkt((char)(Character.getNumericValue('a')+x), y, false, Punkttyp.NORMAL);
                }
            }
        }
    }
}