package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PN extends Ordination {

    private double antalEnheder;
    private final ArrayList<LocalDate> anvendtOrdinationer = new ArrayList<>();

    public PN(LocalDate startDato, LocalDate slutDato) {
        super(startDato, slutDato);
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        if (givesDen.isBefore(getStartDen()) || givesDen.isAfter(getSlutDen()))
        {
            return false;
        }

        anvendtOrdinationer.add(givesDen);
        return true;
    }

    @Override
    public double doegnDosis() {
        //(antal gange ordinationen er anvendt * antal enheder) / (antal dage mellem første og sidste givning)
        double antalModtaget = anvendtOrdinationer.size() * antalEnheder;
        double dageModtaget = ChronoUnit.DAYS.between(anvendtOrdinationer.getFirst(),anvendtOrdinationer.getLast()) + 1;

        return antalModtaget / dageModtaget;
    }

    @Override
    public String getType() {
        return "PN";
    }

    @Override
    public double samletDosis() {
        // TODO
        return anvendtOrdinationer.size() * antalEnheder;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        return anvendtOrdinationer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
