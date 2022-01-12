import java.util.Random;

public class DizzyTurtle extends RaceTurtle {
	private int dizzyness;
	Random rand;

	public DizzyTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
		rand = new Random();
		dizzyness = rand.nextInt(5) + 1;
	}

	@Override
	public void raceStep() {
		switch (dizzyness) {
		case 1:
			left(rand.nextInt(11) - 5);
			break;
		case 2:
			left(rand.nextInt(15) - 7);
			break;
		case 3:
			left(rand.nextInt(21) - 10);
			break;
		case 4:
			left(rand.nextInt(25) - 13);
			break;
		case 5:
			left(rand.nextInt(30) - 15);
			break;
		default:
			left(1);
			break;
		}
		super.raceStep();
	}

	@Override
	public String toString() {
		String s = super.toString();
		s += " - Dizzy (Yrsel:" + dizzyness + ")";
		return s;
	}

}
