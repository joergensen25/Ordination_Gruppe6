package ordination;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligFast {
    private final Dosis[] doser = new Dosis[4];
    private int antalDoser = 0;

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
}
