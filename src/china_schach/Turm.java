public class Turm extends Spielfigur {
    public Turm(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
    }
    public void bewegen(Schnittpunkt ziel) {
        
    }
}
