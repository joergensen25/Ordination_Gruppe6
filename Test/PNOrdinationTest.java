import controller.Controller;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PNOrdinationTest {

    private Controller controller;
    private Laegemiddel laegemiddel;
    private Patient patient;

    // Bruger samme patient og lægemiddel til tests:
    @BeforeEach
    void setUp() {
        controller = Controller.getTestController();
        patient = new Patient("1111111", "Susram", 80.00);
        laegemiddel = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "Styk");
    }

    @Test
    void opretPNGyldigDato() {
        LocalDate startDato = LocalDate.of(2023, 1, 1);
        LocalDate slutDato = LocalDate.of(2023, 1, 10);

        // Act
        PN pn = controller.opretPNOrdination(startDato, slutDato, patient, laegemiddel, 1);
        // Assert
        assertNotNull(pn);
        assertEquals(1, patient.getOrdinationer().size());
    }

    @Test
    void opretPNSammedato() {
        LocalDate startDato = LocalDate.of(2023, 1, 1);
        LocalDate slutDato = LocalDate.of(2023, 1, 1);

        // Act
        PN pn = controller.opretPNOrdination(startDato, slutDato, patient, laegemiddel, 1);
        // Assert
        assertNotNull(pn);
        assertEquals(1, patient.getOrdinationer().size());
    }

    @Test
    void opretPnUgyldigDato() {
        LocalDate startDato = LocalDate.of(2023, 1, 10);
        LocalDate slutDato = LocalDate.of(2023, 1, 1);

        // Act
        assertThrows(IllegalArgumentException.class, () -> {
            controller.opretPNOrdination(startDato, slutDato, patient, laegemiddel, 1);
        });
        assertEquals(0, patient.getOrdinationer().size());
        // Assert
        assertEquals(0, patient.getOrdinationer().size());
    }
}