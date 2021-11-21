
public final class Spieler {
	private final Spielfigur[] dieSpielfiguren;
	private final Spielbrett dasSpielbrett;
	private final String name;
	private final boolean hatRoteSpielfiguren;

	/**
	 * @param name
	 * @param hatRoteSpielfiguren
	 */
	public Spieler(final String name, final boolean hatRoteSpielfiguren) {
        this.name                   = name;
        this.hatRoteSpielfiguren    = hatRoteSpielfiguren;

		// TODO - implement Spieler.Spieler
		throw new UnsupportedOperationException();
	}

    public String getName() {
        return name;
    }

    public boolean getHatRoteSpielfiguren() {
        return hatRoteSpielfiguren;
    }
}

