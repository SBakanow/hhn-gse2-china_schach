import greenfoot.World;

public final class Spielbrett extends World {

  private final int offsetX = 300;
  private final int offsetY = 50;
  private final int scalingY = 100;
  private final int scalingX = 100;
  private Spieler[] dieSpieler;
  private Schnittpunkt[][] dieSchnittpunkte = new Schnittpunkt[9][10];
  private Spiel spiel = new Spiel(this);

  public Spielbrett() {
    super(1400, 1000, 1);
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
   * Prepare the world for the start of the program. That is: create the initial objects and add
   * them to the world.
   */
  private void prepare() {
    for (int x = 0; x < 9; ++x) {
      for (int y = 0; y < 10; ++y) {
        addObject(dieSchnittpunkte[x][y],
            x * scalingX + offsetX,
            y * scalingY + offsetY);
      }
    }
    final var bauer1 = new Bauer(Farbe.ROT);
    addObject(bauer1, 300, 650);
    bauer1.setPosition();
    final var bauer3 = new Bauer(Farbe.ROT);
    addObject(bauer3, 500, 650);
    bauer3.setPosition();
    final var bauer4 = new Bauer(Farbe.ROT);
    addObject(bauer4, 700, 650);
    bauer4.setPosition();
    final var bauer5 = new Bauer(Farbe.ROT);
    addObject(bauer5, 900, 650);
    bauer5.setPosition();
    final var bauer7 = new Bauer(Farbe.ROT);
    addObject(bauer7, 1100, 650);
    bauer7.setPosition();

    final var bauer8 = new Bauer(Farbe.SCHWARZ);
    addObject(bauer8, 300, 350);
    bauer8.setPosition();
    final var bauer10 = new Bauer(Farbe.SCHWARZ);
    addObject(bauer10, 500, 350);
    bauer10.setPosition();
    final var bauer11 = new Bauer(Farbe.SCHWARZ);
    addObject(bauer11, 700, 350);
    bauer11.setPosition();
    final var bauer12 = new Bauer(Farbe.SCHWARZ);
    addObject(bauer12, 900, 350);
    bauer12.setPosition();
    final var bauer14 = new Bauer(Farbe.SCHWARZ);
    addObject(bauer14, 1100, 350);
    bauer14.setPosition();
    
    final var elefant1 = new Elefant(Farbe.ROT);
    addObject(elefant1, 500, 950);
    elefant1.setPosition();
    final var elefant3 = new Elefant(Farbe.ROT);
    addObject(elefant3, 900, 950);
    elefant3.setPosition();
    final var elefant2 = new Elefant(Farbe.SCHWARZ);
    addObject(elefant2, 900, 50);
    elefant2.setPosition();
    final var elefant4 = new Elefant(Farbe.SCHWARZ);
    addObject(elefant4, 500, 50);
    elefant4.setPosition();

    final var turmLR = new Turm(Farbe.SCHWARZ);
    addObject(turmLR, 300, 50);
    turmLR.setPosition();
    final var turmRR = new Turm(Farbe.SCHWARZ);
    addObject(turmRR, 1100, 50);
    turmRR.setPosition();
    final var turmLB = new Turm(Farbe.ROT);
    addObject(turmLB, 300, 950);
    turmLB.setPosition();
    final var turmRB = new Turm(Farbe.ROT);
    addObject(turmRB, 1100, 950);
    turmRB.setPosition();

    final var kaiser1 = new Kaiser(Farbe.ROT);
    addObject(kaiser1, 700, 950);
    kaiser1.setPosition();
    final var kaiser2 = new Kaiser(Farbe.SCHWARZ);
    addObject(kaiser2, 700, 50);
    kaiser2.setPosition();

    final var mandarin1 = new Mandarin(Farbe.ROT);
    addObject(mandarin1, 600, 950);
    mandarin1.setPosition();
    final var mandarin2 = new Mandarin(Farbe.ROT);
    addObject(mandarin2, 800, 950);
    mandarin2.setPosition();
    final var mandarin3 = new Mandarin(Farbe.SCHWARZ);
    addObject(mandarin3, 600, 50);
    mandarin3.setPosition();
    final var mandarin4 = new Mandarin(Farbe.SCHWARZ);
    addObject(mandarin4, 800, 50);
    mandarin4.setPosition();

    final var reiter1 = new Reiter(Farbe.ROT);
    addObject(reiter1, 400, 950);
    reiter1.setPosition();
    final var reiter2 = new Reiter(Farbe.ROT);
    addObject(reiter2, 1000, 950);
    reiter2.setPosition();
    final var reiter3 = new Reiter(Farbe.SCHWARZ);
    addObject(reiter3, 400, 50);
    reiter3.setPosition();
    final var reiter4 = new Reiter(Farbe.SCHWARZ);
    addObject(reiter4, 1000, 50);
    reiter4.setPosition();

    final var geschütz1 = new Geschütz(Farbe.ROT);
    addObject(geschütz1, 400, 750);
    geschütz1.setPosition();
    final var geschütz2 = new Geschütz(Farbe.ROT);
    addObject(geschütz2, 1000, 750);
    geschütz2.setPosition();
    final var geschütz3 = new Geschütz(Farbe.SCHWARZ);
    addObject(geschütz3, 400, 250);
    geschütz3.setPosition();
    final var geschütz4 = new Geschütz(Farbe.SCHWARZ);
    addObject(geschütz4, 1000, 250);
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
        } else if (y == 4 || y == 5) {
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

