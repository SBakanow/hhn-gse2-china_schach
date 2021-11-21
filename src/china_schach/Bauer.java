
import greenfoot.*;


public final class Bauer extends Spielfigur {
    public Bauer(final boolean farbeIstRot) {
        super(farbeIstRot);

        if (farbeIstRot) {
            setImage("English-Pawn-Red.png");
        } else {
            setImage("English-Pawn-Black.png");
        }
    }

    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            setLocation(Greenfoot.getMouseInfo().getX(),
                        Greenfoot.getMouseInfo().getY());
        }
        if (Greenfoot.mouseDragEnded(this)) {
            bewegen((Schnittpunkt)getOneIntersectingObject(Schnittpunkt.class));
        }
    }

    public void bewegen(final Schnittpunkt ziel) {
        if (ziel != null && istBewegungErlaubt(ziel)) {
            setLocation(((Actor)ziel).getX(), ((Actor)ziel).getY());
            oldX = getX();
            oldY = getY();
            setPosition();
        } else {
            setLocation(oldX, oldY);
            oldX = getX();
            oldY = getY();
        }
    }


    private boolean istBewegungErlaubt(final Schnittpunkt ziel) {
        if (farbeIstRot) {
            if (ziel.getZeile() <= 4) {
                System.out.println(Math.abs(position.getSpalte() - ziel.getSpalte()));
                System.out.println(position.getZeile() == ziel.getZeile());

                if (Math.abs(position.getSpalte() - ziel.getSpalte()) == 1 &&
                    position.getZeile() == ziel.getZeile()) {
                    return true;
                }
            }
            if (position.getZeile() - ziel.getZeile() == 1 &&
                position.getSpalte() == ziel.getSpalte()) {
                return true;
            }
        } else {
            if (ziel.getZeile() <= 5) {
                if (Math.abs(position.getSpalte() - ziel.getSpalte()) == 1 &&
                    position.getZeile() == ziel.getZeile()) {
                    return true;
                }
            }
            if (position.getZeile() - ziel.getZeile() == -1 &&
                position.getSpalte() == ziel.getSpalte()) {
                return true;
            }
        }

        return false;
    }
}

