public class Reiter extends Spielfigur {
    
    
    public Reiter(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
    }
    public void bewegen(Schnittpunkt ziel) {
        
    }
}