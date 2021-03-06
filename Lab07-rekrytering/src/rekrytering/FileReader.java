package rekrytering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	/**
	 * Returnerar max nbrOfRows rader från filen som en vektor av Applicant-objekt.
	 * Läser i filen tills det inte finns fler rader eller tills man läst nbrOfRows
	 * rader (det som inträffar först). Returnerar null om filen inte finns.
	 */
	public static Applicant[] readFromFile(String fileName, int nbrOfRows) {
		Scanner scan;
		try {
			scan = new Scanner(new File(fileName), "utf-8");
		} catch (FileNotFoundException e) {
			System.err.println("File not found" + fileName);
			e.printStackTrace();
			return null;
		}

		Applicant[] apcTemp = new Applicant[nbrOfRows];

		int i = 0;

		while (scan.hasNext()) {
			String name = scan.next() + " " + scan.next();
			String grades = scan.next();
			Applicant curr = new Applicant(name, grades);
			apcTemp[i] = curr;
			i++;
		}

		Applicant[] apc = new Applicant[i];
		for (int p = 0; p < i; p++) {
			apc[p] = apcTemp[p];
		}

		// Här kan du använda Scannern för att läsa från filen fileName.
		// Varje rad motsvarar en Applicant. Kontrollera vad Applicants konstruktor
		// kräver
		// Alla Applicant-objekt (max nbrOfRows stycken) ska lagras i en
		// Applicant-vektor och returneras på slutet
		return apc; // Byt ut denna rad mot hela lösningen
	}
}
