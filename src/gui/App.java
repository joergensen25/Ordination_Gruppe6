package gui;

import javafx.application.Application;
import ordination.DagligSkaev;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
//HAllo
	public static void main(String[] args) {
		Application.launch(StartVindue.class);

		DagligSkaev ds = new DagligSkaev(LocalDate.of(2025, 7, 11), LocalDate.of(2025,7,14));
		ds.opretDosis(LocalTime.of(14, 30), 5);
		System.out.println(ds.samletDosis());
	}
}
