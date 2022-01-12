import java.util.ArrayList;
import java.util.Random;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> winners = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		Random rand = new Random();
		boolean loop = true;

		for (int i = 1; i < 9; i++) {
			int whichTurtle = (rand.nextInt(3) + 1);
			switch (whichTurtle) {
			case 1:
				turtles.add(new DizzyTurtle(w, i));
				break;
			case 2:
				turtles.add(new AbsentMindedTurtle(w, i));
				break;
			case 3:
				turtles.add(new MoleTurtle(w, i));
				break;
			}
			System.out.println(turtles.get(i - 1).toString());
		}

		while (loop) {
			for (int i = 0; i < turtles.size(); i++) {
				turtles.get(i).raceStep();
				RaceWindow.delay(10);
				if (turtles.get(i).getX() >= RaceWindow.X_END_POS) {
					winners.add(turtles.get(i));
					turtles.remove(turtles.get(i));
					if (winners.size() >= 3) {
						loop = false;
					}
				}
			}
		}

		for (int i = 1; i <= 3; i++) {
			System.out.println("\nPå plats " + i + ": " + winners.get(i - 1).toString());
		}
	}

}
