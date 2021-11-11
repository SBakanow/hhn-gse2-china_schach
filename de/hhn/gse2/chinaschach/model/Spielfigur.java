package de.hhn.gse2.chinaschach.model;

public abstract class Spielfigur {

	protected Spieler besitzer;
	private Spiel dasSpiel;
	protected Schnittpunkt derSchnittpunkt;
	protected boolean farbeIstRot;
	protected Schittpunkt position;
	protected boolean geschlagen;

	public abstract void bewegen();

}