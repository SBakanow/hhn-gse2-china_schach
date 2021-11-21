import greenfoot.*;
public final class Spielbrett extends World {
    private Spieler[] dieSpieler;
    private Schnittpunkt[][] dieSchnittpunkte = new Schnittpunkt[9][10];
    private Spiel spiel = new Spiel(this);
    private final int offsetX = 50;
    private final int offsetY = 50;
    private final int scalingY = 100;
    private final int scalingX = 100;

    public Spielbrett() {
        super(900, 996, 1);
        initSchnittpunkte();
        prepare();
    }
    
    public void act() {
        
    }


    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 10; ++y) {
                addObject(dieSchnittpunkte[x][y],
                          x * scalingX + offsetX,
                          y * scalingY + offsetY);
            }
        }

        final var bauer1 = new Bauer(true);
        addObject(bauer1, 649, 647);
        bauer1.setPosition();
        final var bauer2 = new Bauer(false);
        addObject(bauer2, 249, 346);
        bauer2.setPosition();
        final var elefant1 = new Elefant(true);
        addObject(elefant1, 243, 947);
        elefant1.setPosition();
        final var elefant2 = new Elefant(false);
        addObject(elefant2, 652, 48);
        elefant2.setPosition();

        final var turmLR = new Turm(false);
        addObject(turmLR, 50, 50);
        turmLR.setPosition();
        final var turmRR = new Turm(false);
        addObject(turmRR, 850, 50);
        turmRR.setPosition();
        final var turmLB = new Turm(true);
        addObject(turmLB, 50, 950);
        turmLB.setPosition();
        final var turmRB = new Turm(true);
        addObject(turmRB, 850, 950);
        turmRB.setPosition();

        final var kaiser1 = new Kaiser(true);
        addObject(kaiser1, 450, 947);
        kaiser1.setPosition();
        final var kaiser2 = new Kaiser(false);
        addObject(kaiser2, 450, 48);
        kaiser2.setPosition();

        final var mandarin1 = new Mandarin(true);
        addObject(mandarin1, 350, 947);
        mandarin1.setPosition();
        final var mandarin2 = new Mandarin(true);
        addObject(mandarin2, 550, 947);
        mandarin2.setPosition();
        final var mandarin3 = new Mandarin(false);
        addObject(mandarin3, 350, 48);
        mandarin3.setPosition();
        final var mandarin4 = new Mandarin(false);
        addObject(mandarin4, 550, 48);
        mandarin4.setPosition();

        final var reiter1 = new Reiter(true);
        addObject(reiter1, 150, 947);
        reiter1.setPosition();
        final var reiter2 = new Reiter(true);
        addObject(reiter2, 750, 947);
        reiter2.setPosition();
        final var reiter3 = new Reiter(false);
        addObject(reiter3, 150, 48);
        reiter3.setPosition();
        final var reiter4 = new Reiter(false);
        addObject(reiter4, 750, 48);
        reiter4.setPosition();
    }

    /**
     * Initialisiere die Schnittpunkte
     */
    private void initSchnittpunkte() {
        for (int x = 0; x < 9; ++x) {
            for (int y = 0; y < 10; ++y) {
                if (y == 0 || y == 8) {
                    if (x >= 3 && x <= 5) {
                        dieSchnittpunkte[x][y] =
                            new Schnittpunkt((char)(Character.getNumericValue('a') + x),
                                             y,
                                             true,
                                             Punkttyp.FESTUNG);
                    } else {
                        dieSchnittpunkte[x][y] =
                            new Schnittpunkt((char)(Character.getNumericValue('a') + x),
                                             y,
                                             true,
                                             Punkttyp.NORMAL);
                    }
                } else if (y == 4 || y == 5 ) {
                    dieSchnittpunkte[x][y] =
                        new Schnittpunkt((char)(Character.getNumericValue('a') + x),
                                         y,
                                         false,
                                         Punkttyp.FLUSS);
                } else if ((x >= 3 && x <= 5) && ((y <= 2) || (y >= 7))) {
                    dieSchnittpunkte[x][y] =
                        new Schnittpunkt((char)(Character.getNumericValue('a') + x),
                                         y,
                                         false,
                                         Punkttyp.FESTUNG);
                } else {
                    dieSchnittpunkte[x][y] =
                        new Schnittpunkt((char)(Character.getNumericValue('a') + x),
                                         y,
                                         false,
                                         Punkttyp.NORMAL);
                }
            }
        }
    }
}

