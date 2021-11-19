public class Geschütz extends Spielfigur {

    private Spielfigur schild;
    
    public Geschütz(boolean farbeIstRot) {
        super(farbeIstRot);
        if(farbeIstRot)
            setImage("image/RotBauer");
        else
            setImage("image/SchwarzBauer");
    }
    
    public void bewegen(Schnittpunkt ziel) {
        
    }

}