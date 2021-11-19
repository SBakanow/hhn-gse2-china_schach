public class Elefant extends Spielfigur {
    public Elefant(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
    }
    public void bewegen(Schnittpunkt ziel) {
        
    }
}