import controller.Controller;
import ordination.DagligFast;
import ordination.Laegemiddel;
import ordination.Patient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DagligFastTest {

    @Test
    void opretDagligFastGyldig() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-6769", "Rasmus", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        LocalDate startDato = LocalDate.of(2023, 1, 1);
        LocalDate slutDato = LocalDate.of(2023, 1,10 );

        // Act
        DagligFast df = controller.opretDagligFastOrdination(startDato, slutDato, patient, laegemiddel, 1, 1, 1, 1);
        // Assert
        assertNotNull(df);
        assertEquals(1, patient.getOrdinationer().size());

    }

    @Test
    void opretDagligFastSammeDato() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-6769", "Rasmus", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        LocalDate startDato = LocalDate.of(2023, 1, 1);
        LocalDate slutDato = LocalDate.of(2023, 1, 1);

        // Act
        DagligFast df = controller.opretDagligFastOrdination(startDato, slutDato, patient, laegemiddel, 1, 1, 1, 1);
        // Assert
        assertNotNull(df);
        assertEquals(1, patient.getOrdinationer().size());

    }

    @Test
    void opretDagligFastUgyldigDato() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-6769", "Rasmus", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        LocalDate startDato = LocalDate.of(2023, 1, 10);
        LocalDate slutDato = LocalDate.of(2023, 1, 1);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            controller.opretDagligFastOrdination(startDato, slutDato, patient, laegemiddel, 1, 1, 1, 1);
        });
        assertEquals(0, patient.getOrdinationer().size());
    }
}
