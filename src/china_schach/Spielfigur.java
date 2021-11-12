import greenfoot.*;

public abstract class Spielfigur extends Actor {

	protected Spieler besitzer;
	protected Schnittpunkt position;
	protected boolean farbeIstRot;
	protected boolean geschlagen;

	/**
	 * 
	 * @param ziel
	 */
	public abstract void bewegen(Schnittpunkt ziel);

	/**
	 * 
	 * @param farbeIstRot
	 */
	public Spielfigur(boolean farbeIstRot) {
		// TODO - implement Spielfigur.Spielfigur
		throw new UnsupportedOperationException();
	}

}