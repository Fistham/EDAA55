package rekrytering;

import java.util.Arrays;

public class FindBestCandidates {
	private static final double MIN_AVG_GRADE = 4.6;

	public static void main(String[] args) {

		Applicant[] apc = FileReader.readFromFile("applications_all.txt", 300);

//		for (int i = 0; i < apc.length; i++) {
//			System.out.println(apc[i]);
//		}
//		System.out.println();

		Applicant[] bestApc = findBestCandidates(apc);
		Arrays.sort(bestApc);
		for (int i = 0; i < bestApc.length; i++) {
			System.out.println(bestApc[i]);
		}

		// Läs från fil (Börja med "applications_small.txt), spara resultatet i en
		// vektor

		// Skicka in Applicant-vektorn (som du fick i föregående steg) till metoden
		// findBestCandidiates (nedan)
		// Spara resultatet i en vektor

		// Printa resultatet från findBestCandidates
	}

	public static Applicant[] findBestCandidates(Applicant[] applicants) {
		// Hitta alla kandidater som har medelbetyg över MIN_AVG_GRADE
		// Lagra alla dessa kandidater i en vektor, returnera vektorn
		Applicant[] apcTemp = new Applicant[applicants.length];
		int j = 0;

		for (int i = 0; i < applicants.length; i++) {
			if (applicants[i].getAvgGrade() >= MIN_AVG_GRADE) {
				apcTemp[j] = applicants[i];
				j++;
			}
		}

		Applicant[] apc = new Applicant[j];
		for (int i = 0; i < j; i++) {
			apc[i] = apcTemp[i];
		}

		return apc; // Byt ut denna rad mot hela din egen lösning
	}
}
