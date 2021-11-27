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
  
  public boolean prüfeKaiserSicht(Spielfigur figur, Schnittpunkt ziel) {
      var kaiser1 = spiel.getSpielfiguren()[30];
      var kaiser2 = spiel.getSpielfiguren()[31];
      int spalteKaiser1 = kaiser1.getSchnittpunkt().getSpalte();
      int spalteKaiser2 = kaiser2.getSchnittpunkt().getSpalte();
      int zeileKaiser1 = kaiser1.getSchnittpunkt().getZeile();
      int zeileKaiser2 = kaiser2.getSchnittpunkt().getZeile();
      
      if(spalteKaiser1 == spalteKaiser2 
      && figur.getSchnittpunkt().getSpalte() == spalteKaiser1
      && ziel.getSpalte() != spalteKaiser1
      && !(figur instanceof Kaiser)) {
          for(var position: spiel.getSchnittpunkte()[spalteKaiser1]) {
              if(position.getSpielfigur() != null 
                && !position.getSpielfigur().istGeschlagen()
                && !(position.getSpielfigur() instanceof Kaiser)
                && figur != position.getSpielfigur()
                && (position.getZeile() < zeileKaiser1 && position.getZeile() > zeileKaiser2)) {
                      return true;
              }
          }
          return false;
      } else if (figur instanceof Kaiser 
          && ((ziel.getSpalte() == spalteKaiser1 && figur != kaiser1) 
          || (ziel.getSpalte() == spalteKaiser2 && figur != kaiser2))) {
          for(var position: spiel.getSchnittpunkte()[ziel.getSpalte()]) {
              if(position.getSpielfigur() != null 
                && !position.getSpielfigur().istGeschlagen()
                && !(position.getSpielfigur() instanceof Kaiser)
                && (position.getZeile() < zeileKaiser1 && position.getZeile() > zeileKaiser2)) {
                      return true;
              }
          }
          return false;
      }
      return true;
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

