import greenfoot.Actor;

public final class Schnittpunkt extends Actor {

  private final int zeile;
  private final int spalte;
  private final boolean startpunkt;
  private final Punkttyp punkttyp;
  private Spielfigur dieSpielfigur;

  public Schnittpunkt(final int spalte,
      final int zeile,
      final boolean startpunkt,
      final Punkttyp punkttyp) {
    // TODO - implement Schnittpunkt.Schnittpunkt
    this.zeile = zeile;
    this.spalte = spalte;
    this.startpunkt = startpunkt;
    this.punkttyp = punkttyp;
  }

  public boolean setSpielfigur(Spielfigur figur) {
    boolean result = false;
    dieSpielfigur = figur;
    return result;
  }

  public Spielfigur getSpielfigur() {
    return dieSpielfigur;
  }

  public void removeSpielfigur() {
    dieSpielfigur = null;
  }

  public int getZeile() {
    return zeile;
  }

  public int getSpalte() {
    return spalte;
  }

  public boolean getStartpunkt() {
    return startpunkt;
  }

  public Punkttyp getPunkttyp() {
    return punkttyp;
  }
}

