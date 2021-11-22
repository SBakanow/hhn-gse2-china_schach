import greenfoot.Actor;


public abstract class Spielfigur extends Actor {


  protected final Farbe farbe;
  protected Schnittpunkt position;
  protected int oldX;
  protected int oldY;
  protected boolean geschlagen;

  /**
   * @param farbe Gibt an, ob die Spielfigur rot ist oder nicht.
   */
  public Spielfigur(final Farbe farbe) {
    // TODO - implement Spielfigur.Spielfigur
    this.farbe = farbe;
  }

  /**
   * @param schnittpunkte Ziel an dem die Spielfigur hin will.
   */
  public abstract boolean bewegen(Schnittpunkt[][] schnittpunkte);


  /**
   * Setze die Position der Spielfigur
   */
  public void setPosition() {
    if (position != null) {
      position.removeSpielfigur();

    }
  }

  public void isLocationValid() {

    position = (Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class);
    position.setSpielfigur(this);
    oldX = getX();
    oldY = getY();
  }


}

