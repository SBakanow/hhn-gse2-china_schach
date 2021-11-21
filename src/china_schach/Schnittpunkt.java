
import greenfoot.*;


public final class Schnittpunkt extends Actor {
    private Spielfigur dieSpielfigur;
    private final Spielbrett dasSpielbrett;
    private final int zeile;
    private final char spalte;
    private final boolean startpunkt;
    private final Punkttyp punkttyp;

    public Schnittpunkt(final char spalte,
                        final int zeile,
                        final boolean startpunkt,
                        final Punkttyp punkttyp) {
        // TODO - implement Schnittpunkt.Schnittpunkt
        this.zeile      = zeile;
        this.spalte     = spalte;
        this.startpunkt = startpunkt;
        this.punkttyp   = punkttyp;

        switch (punkttyp) {
            case FESTUNG:   setImage("red-draught.png");    break;
            case FLUSS:     setImage("yellow-draught.png"); break;
            default:        setImage("blue-draught.png");   break;
        }
    }

    public void setSpielfigur(final Spielfigur figur) {
        getWorld().removeObject(dieSpielfigur);
        dieSpielfigur = figur;
    }

    public void removeSpielfigur() {
        dieSpielfigur = null;
    }

    public int getZeile() {
        return zeile;
    }

    public char getSpalte() {
        return spalte;
    }

    public boolean getStartpunkt() {
        return startpunkt;
    }

    public Punkttyp getPunkttyp() {
        return punkttyp;
    }
}

