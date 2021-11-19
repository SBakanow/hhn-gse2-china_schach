public class Kaiser extends Spielfigur {
    public Kaiser(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
    }
    public void bewegen(Schnittpunkt ziel) {
        
    }
}