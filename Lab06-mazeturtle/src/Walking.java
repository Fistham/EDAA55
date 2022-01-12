import java.util.Scanner;

import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class Walking {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "Yalla let go");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number between 1-5 to select Maze: ");
		Maze m = new Maze(input.nextInt());
		m.draw(w);
		Turtle t = new Turtle(w,m.getXEntry(),m.getYEntry());
		MazeWalker mW = new MazeWalker(t);
		t.penDown();
		while(!m.atExit(t.getX(), t.getY())) {
			mW.walk(m);
		}
		
		System.out.println("Turns: " + mW.getTurns() + "\n" + "Steps: " + mW.getSteps());
		
	}

}
