import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrdinationAntalDageTest {

    @Test
    void testAntalDageSammeDag() {
        Laegemiddel lm = new Laegemiddel("Test", 1, 1, 1, "stk");
        Patient patient = new Patient("111111-1111", "Testperson", 67);
        PN pn = new PN(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 1), patient);
    }
    @Test
    void testAntalDageFlereDage() {

    }

}
