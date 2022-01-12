import java.util.ArrayList;

public class TurtleRace {

	public static void main(String[] args) {
		ArrayList<RaceTurtle> turtles = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> winners = new ArrayList<RaceTurtle>();
		RaceWindow w = new RaceWindow();
		boolean loop = true;
		
		for (int i = 1; i < 9; i++) {
			turtles.add(new RaceTurtle(w,i));
		}
		
		while(loop) {
			for(int i = 0 ; i < turtles.size() ; i++) {
				turtles.get(i).raceStep();
				RaceWindow.delay(10);
				if(turtles.get(i).getX() >= RaceWindow.X_END_POS) {
					winners.add(turtles.get(i));
					turtles.remove(turtles.get(i));
					if(turtles.isEmpty()) {
						loop = false;
					}
				}
			}
		}
		
		for(int i = 1; i <= 3; i++) {
			System.out.println("På plats " + i + ": " + winners.get(i-1).toString());
		}
	}

}
