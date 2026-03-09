import controller.Controller;
import ordination.DagligSkaev;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DagligSkævTest {

    private Controller controller;
    private Patient patient;
    private Laegemiddel laegemiddel;


    @BeforeEach
    void setUp() throws Exception {
        controller = Controller.getTestController();
        patient = new Patient("111111-1111", "Test", 67.67);
        laegemiddel = new Laegemiddel("Percocet", 0.25, 0.25, 0.25, "Styk");
    }

    @Test
    void testOpretDagligSkaev() {
        // Opretter 4 tider
        LocalTime[] tider = {
                LocalTime.of(8, 0),
                LocalTime.of(12, 0),
                LocalTime.of(16, 0)
        };
        // Opretter 3 antal
        double[] antal = {1.0, 2.0, 3.0};

        DagligSkaev ds = controller.opretDagligSkaevOrdination(
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 9, 5),
                patient,
                laegemiddel,
                tider,
                antal);

        assertEquals(6.0, ds.doegnDosis());
        assertEquals(30.0, ds.samletDosis());
    }

    @Test
    void opretDagligSkaevUgyldigDato() {
        LocalTime[] tider = {
                LocalTime.of(8, 0),
                LocalTime.of(12, 0),
                LocalTime.of(16, 0)
        };
        double[] antal = {1.0, 2.0, 3.0};
        assertThrows(IllegalArgumentException.class, () -> {
            controller.opretDagligSkaevOrdination(
                    LocalDate.of(2026, 9, 5),
                    LocalDate.of(2026, 9, 1),
                    patient,
                    laegemiddel,
                    tider,
                    antal
            );
        });
    }

    @Test
    void opretDagligSkaevForskelligLaengde() {
        LocalTime[] tider = {
                LocalTime.of(8,0),
                LocalTime.of(12,0),
                LocalTime.of(16,0)
        };

        double[] antal = {1.0, 2.0, 3.0, 4.0};

        assertThrows(IllegalArgumentException.class, () -> {
            controller.opretDagligSkaevOrdination(
                    LocalDate.of(2026, 9, 1),
                    LocalDate.of(2026, 9, 5),
                    patient,
                    laegemiddel,
                    tider,
                    antal
            );
        });
    }
}
