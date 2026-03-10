import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnbefaletDosisTest {

    private Controller controller;
    private Laegemiddel laegemiddel;

    // Bruger samme lægemiddel til tests:
    @BeforeEach
    void setUp() {
        controller = Controller.getTestController();
        laegemiddel = new Laegemiddel("Paracetamol", 1,
                1.5, 2, "Styk");
    }

    @Test
    void testAnbefaletDosisPrDoegnLet() {
        Patient patient = new Patient("121110-8765", "Rasmusine", 24.9);

        //Act
        double expected = 24.9;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testAnbefaletDosisPrDoegnNormal() {
        Patient patient = new Patient("121110-8765", "Rasmus", 80.00);

        //Act
        double expected = 120.0;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testAnbefaletDosisPrDoegnNormalNedreGrænse() {
        Patient patient = new Patient("121110-8765", "Lucaline", 25.00);

        //Act
        double expected = 37.5;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testAnbefaletDosisPrDoegnNormalØvreGrænse() {
        Patient patient = new Patient("121110-8765", "Luca", 120.00);

        //Act
        double expected = 180.0;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void testAnbefaletDosisPrDoegnTung() {
        Patient patient = new Patient("121110-8765", "Noah", 126);

        //Act
        double expected = 252.0;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }
}

