import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class MovingSquareClicker {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "Moving Square");
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while(true) {
			w.waitForMouseClick();
			sq.erase(w);
			sq.move(w.getClickedX()-sq.getX(), w.getClickedY()-sq.getY());
			sq.draw(w);
		}
	}
}
