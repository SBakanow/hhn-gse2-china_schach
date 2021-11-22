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
        spiel.starten();
    }
    
    public Schnittpunkt getSchnittpunkt(int x, int y) {
        return dieSchnittpunkte[x][y];
    }

    public Schnittpunkt[][] getSchnittpunkte() {
        return dieSchnittpunkte;
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
        addObject(bauer1, 50, 650);
        bauer1.setPosition();
        final var bauer3 = new Bauer(true);
        addObject(bauer3, 250, 650);
        bauer3.setPosition();
        final var bauer4 = new Bauer(true);
        addObject(bauer4, 450, 650);
        bauer4.setPosition();
        final var bauer5 = new Bauer(true);
        addObject(bauer5, 650, 650);
        bauer5.setPosition();
        final var bauer7 = new Bauer(true);
        addObject(bauer7, 850, 650);
        bauer7.setPosition();

        final var bauer8 = new Bauer(false);
        addObject(bauer8, 50, 350);
        bauer8.setPosition();
        final var bauer10 = new Bauer(false);
        addObject(bauer10, 250, 350);
        bauer10.setPosition();
        final var bauer11 = new Bauer(false);
        addObject(bauer11, 450, 350);
        bauer11.setPosition();
        final var bauer12 = new Bauer(false);
        addObject(bauer12, 650, 350);
        bauer12.setPosition();
        final var bauer14 = new Bauer(false);
        addObject(bauer14, 850, 350);
        bauer14.setPosition(); 
        final var elefant1 = new Elefant(true);
        addObject(elefant1, 250, 950);
        elefant1.setPosition();
        final var elefant3 = new Elefant(true);
        addObject(elefant3, 650, 950);
        elefant3.setPosition();
        final var elefant2 = new Elefant(false);
        addObject(elefant2, 650, 50);
        elefant2.setPosition();
        final var elefant4 = new Elefant(false);
        addObject(elefant4, 250, 50);
        elefant4.setPosition();

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
        addObject(kaiser1, 450, 950);
        kaiser1.setPosition();
        final var kaiser2 = new Kaiser(false);
        addObject(kaiser2, 450, 50);
        kaiser2.setPosition();

        final var mandarin1 = new Mandarin(true);
        addObject(mandarin1, 350, 950);
        mandarin1.setPosition();
        final var mandarin2 = new Mandarin(true);
        addObject(mandarin2, 550, 950);
        mandarin2.setPosition();
        final var mandarin3 = new Mandarin(false);
        addObject(mandarin3, 350, 50);
        mandarin3.setPosition();
        final var mandarin4 = new Mandarin(false);
        addObject(mandarin4, 550, 50);
        mandarin4.setPosition();
        
        final var reiter1 = new Reiter(true);
        addObject(reiter1, 150, 950);
        reiter1.setPosition();
        final var reiter2 = new Reiter(true);
        addObject(reiter2, 750, 950);
        reiter2.setPosition();
        final var reiter3 = new Reiter(false);
        addObject(reiter3, 150, 50);
        reiter3.setPosition();
        final var reiter4 = new Reiter(false);
        addObject(reiter4, 750, 50);
        reiter4.setPosition();
        
        final var geschütz1= new Geschütz(true);
        addObject(geschütz1, 150, 750);
        geschütz1.setPosition();
        final var geschütz2= new Geschütz(true);
        addObject(geschütz2, 750, 750);
        geschütz2.setPosition();
        final var geschütz3= new Geschütz(false);
        addObject(geschütz3, 150, 250);
        geschütz3.setPosition();
        final var geschütz4= new Geschütz(false);
        addObject(geschütz4, 750, 250);
        geschütz4.setPosition();
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
                            new Schnittpunkt(x,
                                             y,
                                             true,
                                             Punkttyp.FESTUNG);
                    } else {
                        dieSchnittpunkte[x][y] =
                            new Schnittpunkt(x,
                                             y,
                                             true,
                                             Punkttyp.NORMAL);
                    }
                } else if (y == 4 || y == 5 ) {
                    dieSchnittpunkte[x][y] =
                        new Schnittpunkt(x,
                                         y,
                                         false,
                                         Punkttyp.FLUSS);
                } else if ((x >= 3 && x <= 5) && ((y <= 2) || (y >= 7))) {
                    dieSchnittpunkte[x][y] =
                        new Schnittpunkt(x,
                                         y,
                                         false,
                                         Punkttyp.FESTUNG);
                } else {
                    dieSchnittpunkte[x][y] =
                        new Schnittpunkt(x,
                                         y,
                                         false,
                                         Punkttyp.NORMAL);
                }
            }
        }
    }
}

