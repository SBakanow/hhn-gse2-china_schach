import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public final class ChinaSchachKontrolle {

  private static ChinaSchachKontrolle instance;
  private Spiel spiel;

  private ChinaSchachKontrolle(Spiel spiel) {
    // TODO - implement ChinaSchachKontrolle.ChinaSchachKontrolle
    this.spiel = spiel;
  }

  public static ChinaSchachKontrolle getInstance(Spiel spiel) {
    if (instance == null) {
      instance = new ChinaSchachKontrolle(spiel);
    }
    return instance;
  }

  public boolean prüfePatt() {
    // TODO - implement ChinaSchachKontrolle.prüfePatt
    throw new UnsupportedOperationException();
  }

  public boolean prüfeSchach() {
    // TODO - implement ChinaSchachKontrolle.prüfeSchach
    throw new UnsupportedOperationException();
  }

  public boolean prüfeMatt() {
    // TODO - implement ChinaSchachKontrolle.prüfeMatt
    if(spiel.getSpielfiguren()[30].istGeschlagen() || spiel.getSpielfiguren()[31].istGeschlagen()) {
        return true;
    }
    return false;
  }
}

