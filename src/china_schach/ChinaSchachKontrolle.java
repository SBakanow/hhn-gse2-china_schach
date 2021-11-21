
public final class ChinaSchachKontrolle {
    private static ChinaSchachKontrolle instance;

    static public boolean prüfeGeschlagen(final Spielfigur figur) {
        // TODO - implement ChinaSchachKontrolle.prüfeGeschlagen
        throw new UnsupportedOperationException();
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
        throw new UnsupportedOperationException();
    }

    public static ChinaSchachKontrolle getInstance() {
        if (instance == null) {
            instance = new ChinaSchachKontrolle();
        }
        return instance;
    }


    private ChinaSchachKontrolle() {
        // TODO - implement ChinaSchachKontrolle.ChinaSchachKontrolle
    }
}

