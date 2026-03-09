import controller.Controller;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Ordination;
import ordination.Patient;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DagligFastTest {

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
        Patient patient = new Patient("121110-8765", "Rasmusine", 15.00);
        Laegemiddel laegemiddel = new Laegemiddel("Paracetamol", 1, 1.5, 2, "Styk");
        //Act
        double expected = 15.0;
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

    @Test
    void opretDagligFast(){
        Controller controller = Controller.getTestController();

    }
    // opret controller daglig fast, og skæv, opret PN
}
