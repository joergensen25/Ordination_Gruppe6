import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerAnbefaletDosisTest {

    private Controller controller;
    private Laegemiddel laegemiddel;

    @BeforeEach
    void setUp() {
        controller = Controller.getTestController();
        laegemiddel = new Laegemiddel("Test", 1.0, 2.0, 3.0, "ml");
    }



    @Test
    void testAnbefaletDosisLetPatient() {
        Patient p = new Patient("111111-1111", "Let", 24.0);

        double actual = controller.anbefaletDosisPrDoegn(p, laegemiddel);


        assertEquals(24.0, actual);
    }


    @Test
    void testAnbefaletDosisNormalPatientNedreGrænse() {
        Patient p = new Patient("111111-1111", "Normal", 25.0);

        double actual = controller.anbefaletDosisPrDoegn(p, laegemiddel);

        assertEquals(50.0, actual);
    }

    @Test
    void testAnbefaletDosisNormalPatientØvreGrænse() {

    }

    @Test
    void testAnbefaletDosisTungPatient() {

    }




}
