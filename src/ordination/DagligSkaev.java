package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class DagligSkaev extends Ordination {

    private final ArrayList<Dosis> doser = new ArrayList<>();

    public DagligSkaev(LocalDate startDato, LocalDate slutDato) {
        super(startDato, slutDato);
    }

    public Dosis opretDosis(LocalTime tid, double antal) {
        if (tid == null) {
            throw new IllegalArgumentException("Tid kan ikke være nul.");
        }
        if (antal <= 0) {
            throw new IllegalArgumentException("Antal skal være større end nul.");
        }
        Dosis d = new Dosis(tid, antal);
        doser.add(d);
        return d;
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * antalDage();
    }

    @Override
    public double doegnDosis() {
        double sum = 0.0;
        for (Dosis d : doser) {
            sum += d.getAntal();
        }
        return sum;
    }

    @Override
    public String getType() {
        return "Daglig skæv ordination";
    }

    public ArrayList<Dosis> getDoser() {
        return doser;
    }
}
