package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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
        return 0;
    }

    @Override
    public double doegnDosis() {
        double sum = 0.0;

        return 0;
    }

    @Override
    public String getType() {
        return "";
    }
}
