package Functions;
import java.util.Objects;

public class Convert {

    private final String planeta;
    private final double liczba_sekund;

    public Convert(String planeta, double liczba_sekund) {
        this.planeta = planeta;
        this.liczba_sekund = liczba_sekund;
    }

    public double wartosc(String planeta) {
        double wartosc = 0;

        if (Objects.equals(planeta, "merkury")) {
            wartosc = 0.2408467;
        }
        if (Objects.equals(planeta, "wenus")) {
            wartosc = 0.61519726;
        }
        if (Objects.equals(planeta, "ziemia")) {
            wartosc = 1;
        }
        if (Objects.equals(planeta, "mars")) {
            wartosc = 1.8808158;
        }
        if (Objects.equals(planeta, "jowisz")) {
            wartosc = 11.862615;
        }
        if (Objects.equals(planeta, "saturn")) {
            wartosc = 29.447498;
        }
        if (Objects.equals(planeta, "uran")) {
            wartosc = 84.016846;
        }
        if (Objects.equals(planeta, "neptun")) {
            wartosc = 164.79132;
        }
        if (Objects.equals(planeta, "pluton")) {
            wartosc = 247;
        }
        return wartosc;
    }


        public double getYears () {
            double rok_ziemski = 31557600;
            double lat_ziemskich = liczba_sekund / rok_ziemski;
            return lat_ziemskich / wartosc(planeta);
        }
    }




