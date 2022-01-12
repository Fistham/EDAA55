import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquare {
	public static void main(String[] args) {
		int oldX = 250;
		int oldY = 250;
		SimpleWindow w = new SimpleWindow(600, 600, "Moving Square");
		Square sq = new Square(oldX, oldY, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int x = w.getClickedX() - oldX;
			int y = w.getClickedY() - oldY;
			int xIncr = x / 10;
			int yIncr = y / 10;
			for (int i = 0; i < 10; i++) {
				SimpleWindow.delay(10);
				sq.erase(w);
				sq.move(xIncr, yIncr);
				oldX = sq.getX();
				oldY = sq.getY();
				sq.draw(w);
				xIncr = +xIncr;
				yIncr = +yIncr;
			}
		}
	}
}