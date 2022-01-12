import java.util.Random;

public class AbsentMindedTurtle extends RaceTurtle {
	private Random rand;
	private int absentMindedness;

	public AbsentMindedTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		rand = new Random();
		absentMindedness = rand.nextInt(101);
	}

	@Override
	public void raceStep() {
		if (absentMindedness < rand.nextInt(101)) {
			super.raceStep();
		}

	}

	@Override
	public String toString() {
		String s = super.toString();
		s += " - Absent (" + absentMindedness + "% frånvarande)";
		return s;
	}

}
