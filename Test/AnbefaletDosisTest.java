import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnbefaletDosisTest {

    @Test
    void anbefaletDosisPrDoegnNormal() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-8765", "Rasmus", 80.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        //Act
        double expected = 120.0;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void anbefaletDosisPrDoegnNormalØvreGrænse() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-8765", "Luca", 120.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        //Act
        double expected = 180.0;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void anbefaletDosisPrDoegnNormalNedreGrænse() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-8765", "Lucaline", 25.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        //Act
        double expected = 37.5;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void anbefaletDosisPrDoegnLet() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-8765", "Rasmusine", 24.9);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        //Act
        double expected = 24.9;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);

    }

    @Test
    void anbefaletDosisPrDoegnTung() {
        Controller controller = Controller.getTestController();
        Patient patient = new Patient("121110-8765", "Noah", 126);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        //Act
        double expected = 252.0;
        double actual = controller.anbefaletDosisPrDoegn(patient, laegemiddel);
        //Assert
        assertEquals(expected, actual);
    }
}

