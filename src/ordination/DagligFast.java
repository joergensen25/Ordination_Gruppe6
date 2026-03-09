package ordination;

import java.time.LocalDate;
import java.time.LocalTime;


public class DagligFast extends Ordination {
    private Dosis[] doser = new Dosis[4];
    private int antalDoser = 0;

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    public Dosis[] getDoser() {
        return doser;
    }

    public Dosis createDosis(LocalTime tid, double antal) {
        if (antalDoser < 4) {
            Dosis dosis = new Dosis(tid, antal);
            doser[antalDoser] = dosis;
            antalDoser++;
            return dosis;
        } else {
            return null;
        }
    }

    @Override
    public double samletDosis() {
        return doegnDosis() * antalDage();
    }

    @Override
    public double doegnDosis() {
        double samletTotal = 0;
        for (Dosis d : doser) {
            if (d != null) {
                samletTotal += d.getAntal();
            }
        }
        return samletTotal;
    }

    @Override
    public String getType() {
        return "Daglig fast ordination";
    }
}
