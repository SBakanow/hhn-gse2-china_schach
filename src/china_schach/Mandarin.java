public class Mandarin extends Spielfigur {
    public Mandarin(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
    }
    public void bewegen(Schnittpunkt ziel) {
        
    }
}