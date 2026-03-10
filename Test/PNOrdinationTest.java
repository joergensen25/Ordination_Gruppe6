import controller.Controller;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNOrdinationTest {

    @Test
    void opretPNGyldigDato() {
        Controller controller = Controller.getTestController();
        LocalDate startDato = LocalDate.of(2023, 1, 1);
        LocalDate slutDato = LocalDate.of(2023, 1, 10);
        Patient patient = new Patient("1111111", "Susram", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        // Act
        PN pn = controller.opretPNOrdination(startDato, slutDato, patient, laegemiddel, 1);
        // Assert
        assertNotNull(pn);
        assertEquals(1, patient.getOrdinationer().size());
    }

    @Test
    void opretPNSammedato() {
        Controller controller = Controller.getTestController();
        LocalDate startDato = LocalDate.of(2023, 1, 1);
        LocalDate slutDato = LocalDate.of(2023, 1, 1);
        Patient patient = new Patient("1111111", "Susram", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        // Act
        PN pn = controller.opretPNOrdination(startDato, slutDato, patient, laegemiddel, 1);
        // Assert
        assertNotNull(pn);
        assertEquals(1, patient.getOrdinationer().size());
    }

    @Test
    void opretPnUgyldigDato() {
        Controller controller = Controller.getTestController();
        LocalDate startDato = LocalDate.of(2023, 1, 10);
        LocalDate slutDato = LocalDate.of(2023, 1, 1);
        Patient patient = new Patient("1111111", "Susram", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            controller.opretPNOrdination(startDato, slutDato, patient, laegemiddel, 1);
        });
        assertEquals(0, patient.getOrdinationer().size());
        // Assert
        assertEquals(0, patient.getOrdinationer().size());

    }
}