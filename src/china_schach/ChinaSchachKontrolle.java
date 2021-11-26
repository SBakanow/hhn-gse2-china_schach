import javax.swing.JOptionPane;
import greenfoot.Greenfoot;

public final class ChinaSchachKontrolle {

  private static ChinaSchachKontrolle instance;
  private Spiel spiel;

  private ChinaSchachKontrolle() {
    // TODO - implement ChinaSchachKontrolle.ChinaSchachKontrolle
  }

  public static ChinaSchachKontrolle getInstance() {
    if (instance == null) {
      instance = new ChinaSchachKontrolle();
    }
    return instance;
  }
  
  public void setSpiel(Spiel spiel) {
      this.spiel = spiel;
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
        Greenfoot.playSound("Chinese-gong-sound.mp3");
        if (spiel.getSpielfiguren()[30].istGeschlagen()) {
            JOptionPane.showMessageDialog(null, 
                              "Rot ist matt, Schwarz gewinnt!", 
                              "Schachmatt", 
                              JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, 
                              "Schwarz ist matt, Rot gewinnt!", 
                              "Schachmatt", 
                              JOptionPane.PLAIN_MESSAGE);
        }
        return true;
    }
    return false;
  }
}

