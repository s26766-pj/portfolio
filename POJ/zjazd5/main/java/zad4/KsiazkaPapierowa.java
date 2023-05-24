package zad4;

public class KsiazkaPapierowa extends Ksiazka {
    private int rokWydania;

    public KsiazkaPapierowa(String tytul, String autor, int liczbaStron, int rokWydania) {
        super(tytul, autor, liczbaStron);
        this.rokWydania = rokWydania;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    @Override
    public String toString() {
        return "KsiazkaPapierowa [tytul=" + getTytul() + ", autor=" + getAutor() + ", liczbaStron=" + getLiczbaStron() + ", rokWydania=" + rokWydania + "]";
    }
}
