import greenfoot.*;
public class Schnittpunkt extends Actor{

    private Spielbrett dasSpielbrett;
    private Spielfigur dieSpielfigur;
    private int zeile;
    private char spalte;
    private boolean startpunkt;
    private Punkttyp punkttyp;

    public Schnittpunkt(char spalte, int zeile, boolean startpunkt, Punkttyp punkttyp) {
        // TODO - implement Schnittpunkt.Schnittpunkt
        this.zeile = zeile;
        this.spalte = spalte;
        this.startpunkt = startpunkt;
        this.punkttyp = punkttyp;
    }
    
    public void setSpielfigur() {
        
    }
}