import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class Turtle5 {

	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		Turtle t = new Turtle(w, 300, 300);
		Random rand = new Random();
		t.jumpTo(w.getWidth()/2,w.getHeight()/2);
		t.penDown();
		for(int i = 0; i < 1000; i++) {
			t.forward(rand.nextInt(10)+1);
			t.left(rand.nextInt(361)-180);
			SimpleWindow.delay(100);
		}
	}

}
