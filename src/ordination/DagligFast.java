package ordination;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast extends Ordination {
    private final Dosis[] doser = new Dosis[4];
    private int antalDoser = 0;

    public DagligFast(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
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
        int samletAntal = 0;
        for (Dosis dosis : doser) {
            samletAntal += dosis.getAntal();
        }
        return samletAntal;
    }

    @Override
    public double doegnDosis() {
        return 0;
    }

    @Override
    public String getType() {
        return "";
    }
}
