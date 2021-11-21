import greenfoot.*;


public final class Elefant extends Spielfigur {
  public Elefant(final boolean farbeIstRot) {
    super(farbeIstRot);

    if (farbeIstRot) {
      setImage("English-Elephant-Red.png");
    } else {
      setImage("English-Elephant-Black.png");
    }
  }

  public void act() {
    if (Greenfoot.mouseDragged(this)) {
      setLocation(Greenfoot.getMouseInfo().getX(),
          Greenfoot.getMouseInfo().getY());
    }
    if (Greenfoot.mouseDragEnded(this)) {
      bewegen((Schnittpunkt) getOneIntersectingObject(Schnittpunkt.class));
    }
  }

  public void bewegen(final Schnittpunkt ziel) {
    if (ziel != null && istBewegungErlaubt(ziel)) {
      setLocation(((Actor) ziel).getX(), ((Actor) ziel).getY());
      oldX = getX();
      oldY = getY();
    } else {
      setLocation(oldX, oldY);
      oldX = getX();
      oldY = getY();
    }
  }


  private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
    if (position.getPunkttyp() == Punkttyp.FLUSS &&
        (position.getZeile() - ziel.getZeile() == -2) &&
        Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 &&
        farbeIstRot) {
      setPosition();
      position = ziel;
      return true;
    } else if (position.getPunkttyp() == Punkttyp.FLUSS &&
        (position.getZeile() - ziel.getZeile() == 2) &&
        Math.abs((int) position.getSpalte() - ziel.getSpalte()) == 2 &&
        !farbeIstRot) {
      setPosition();
      position = ziel;
      return true;
    } else if (Math.abs(position.getZeile() - ziel.getZeile()) == 2 &&
        Math.abs(((int) position.getSpalte() - ziel.getSpalte())) == 2 &&
        position.getPunkttyp() != Punkttyp.FLUSS) {
      setPosition();
      position = ziel;
      return true;
    }

    return false;
  }
}

