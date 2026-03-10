package ordination;

import java.time.LocalDate;
import java.time.LocalTime;


public class DagligFast extends Ordination {
    private Dosis[] doser = new Dosis[4];
    // 0 = morgen, 1 = middag, 2 = aften, 3 = nat

    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient) {
        super(startDen, slutDen, patient);
    }

    public Dosis[] getDoser() {
        return doser;
    }

    public void createDosis(double morgen, double middag, double aften, double nat) {
        doser[0] = new Dosis(LocalTime.of(6, 0), morgen);
        doser[1] = new Dosis(LocalTime.of(13, 0), middag);
        doser[2] = new Dosis(LocalTime.of(18, 0), aften);
        doser[3] = new Dosis(LocalTime.of(23, 0), nat);
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
