import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrdinationAntalDageTest {

    @Test
    void testAntalDageSammeDag() {
        Patient patient = new Patient("111111-1111", "Testperson", 67);
        PN pn = new PN(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 1, 1),
                patient);

        assertEquals(1, pn.antalDage());
    }

    @Test
    void testAntalDageFlereDage() {
        Patient patient = new Patient("111111-1111", "Testperson", 67);
        PN pn = new PN(
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2026, 1, 3),
                patient);

        assertEquals(3, pn.antalDage());

    }

    @Test
    void testAntalUgyldigDage() {
        Patient patient = new Patient("111111-1111", "Testperson", 67);
        LocalDate start = LocalDate.of(2026, 1, 4);
        LocalDate slut = LocalDate.of(2026, 1, 3);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PN(start, slut, patient);
        });
        assertEquals("Startdato skal være før eller lig med slutdato", exception.getMessage());    }
}

