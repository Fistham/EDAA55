import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;

public class MazeWalker {
	private Turtle t;
	private int steps, turns;

	public MazeWalker(Turtle turtle) {
		t = turtle;
		steps = 0;
		turns = 0;
	}

	public void walk(Maze maze) {
		if (maze.wallAtLeft(t.getDirection(), t.getX(), t.getY())
				&& !maze.wallInFront(t.getDirection(), t.getX(), t.getY())) {
			t.forward(1);
			steps++;
			SimpleWindow.delay(1);
		} else if (maze.wallAtLeft(t.getDirection(), t.getX(), t.getY())
				&& maze.wallInFront(t.getDirection(), t.getX(), t.getY())) {
			t.left(-90);
			turns++;
			SimpleWindow.delay(1);
		} else {
			t.left(90);
			turns++;
			t.forward(1);
			steps++;
			SimpleWindow.delay(1);
		}
	}

	public int getTurns() {
		return turns;
	}

	public int getSteps() {
		return steps;
	}
}
