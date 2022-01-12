import java.util.Random;

public class RaceTurtle extends Turtle {
	private int nbr;

	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		this.left(-90);
		this.penDown();
	}

	public void raceStep() {
		Random rand = new Random();
		forward(rand.nextInt(6) + 1);

	}
	
	@Override
	public String toString() {
		String s = "Nummer " + nbr;
		return s;
	}

}
