import greenfoot.World;
import greenfoot.core.WorldHandler;
import javax.swing.JOptionPane;

public final class Spielbrett extends World {

  private final int offsetX = 300;
  private final int offsetY = 50;
  private final int scalingY = 100;
  private final int scalingX = 100;
  private Spieler[] dieSpieler;
  private Schnittpunkt[][] dieSchnittpunkte = new Schnittpunkt[9][10];
  private Spiel spiel = new Spiel(this);
  boolean ende = false;

  public Spielbrett() {
    super(1400, 1000, 1);
    initSchnittpunkte();
    prepare();
    spiel.konfiguriereSpiel();
  }

  
  public void act() {
    if(!ende) {
      ende = spiel.starten();
    }
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

