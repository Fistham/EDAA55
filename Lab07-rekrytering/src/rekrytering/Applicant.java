package rekrytering;

import java.util.Arrays;

public class Applicant implements Comparable<Applicant> {
	// Varje sökande har ett namn och ett antal betyg
	private String name;
	private int[] grades;

	public Applicant(String name, String gradesAsString) {
		this.name = name;
		// Har flyttat tolkningen av betygen till en privat hjälpmetod för att hålla
		// konstruktorn kortare
		// Anropa denna och skicka vidare parametern som innehåller betygen
		parseGrades(gradesAsString);
	}

	private void parseGrades(String gradesAsString) {
		// gradesAsString har formatet x,y,z,q där respektive bokstav är ett betyg
		// Om vi splittar strängen på komma (",") hamnar varje betyg i en vektor
		String[] g = gradesAsString.split(",");
		// Skapa vektorn med heltal
		grades = new int[g.length];
		// Iterera över alla betyg för att översätta dessa till ett heltal
		for (int i = 0; i < g.length; i++) {
			if (g[i].equals("U")) {
				// Om underkänd så räknar vi det som en nolla
				grades[i] = 0;
			} else if (g[i].equals("A")) {
				grades[i] = 5;
			} else if (g[i].equals("B")) {
				grades[i] = 4;
			} else {
				grades[i] = Integer.parseInt(g[i]);
				if(grades[i] > 5 || grades[i] < 0) {
					grades[i] = 0;
				}
			}
		}
	}

	public double getAvgGrade() {
		double avgGrade = 0;
		for (int i = 0; i < grades.length; i++) {
			avgGrade += grades[i];
		}
		avgGrade = avgGrade / grades.length;
		return avgGrade;
	}

	/*
	 * Implementera denna när labbeskrivningen kräver det
	 */
	public String toString() {
		return name + Arrays.toString(grades) + " (avg: " + getAvgGrade() + ")";
		// Fyll i kod här
	}

	/*
	 * Metod för att jämföra detta Applicant-objekt med ett annat och få ut vilket
	 * som är störst. Retunerar något > 0 om detta objektet är störst. Returnerar
	 * något < 0 om other är störst och returnerar 0 om objekten är lika. Används av
	 * javas inbyggda sorteringsmetoder
	 */
	public int compareTo(Applicant other) {
		// Om exakt samma objekt
		if (other == this) {
			return 0;
		}
		// Annars jämför snittbetyget i första hand
		int gradeRes = (int) Math.round((getAvgGrade() - ((Applicant) other).getAvgGrade()) * 100);
		if (gradeRes == 0) {
			// Om snittbetyget är samma, låt namnet avgöra på namnet
			return name.compareTo(((Applicant) other).name);
		}
		return gradeRes;
	}

	public String getName() {
		return name;
	}
}
