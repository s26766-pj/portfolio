package zad4;

public class Ebook extends Ksiazka {
    private int rozmiar;
    private String format;

    public Ebook(String tytul, String autor, int liczbaStron, int rozmiar, String format) {
        super(tytul, autor, liczbaStron);
        this.rozmiar = rozmiar;
        this.format = format;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Ebook [tytul=" + getTytul() + ", autor=" + getAutor() + ", liczbaStron=" + getLiczbaStron() + ", rozmiar=" + rozmiar + ", format=" + format + "]";
    }
}
