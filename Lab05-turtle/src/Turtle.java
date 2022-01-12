import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {

	private SimpleWindow w;
	private double x, y;
	private int alpha;
	private boolean isPenDown;

	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x, y med pennan lyft och huvudet pekande rakt uppåt i
	 * fönstret (i negativ y-riktning).
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.x = x;
		this.y = y;
		alpha = 90;
		w.moveTo(x, y);
		penUp();

	}

	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}

	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}

	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo(getX(),getY());
		x = x + (n * Math.cos(Math.toRadians(alpha)));
		y = y - (n * Math.sin(Math.toRadians(alpha)));
		if (isPenDown) {
			w.lineTo(getX(), getY());
		} else {
			w.moveTo(getX(), getY());
		}
	}

	/** Vrider beta grader åt vänster runt pennan. */
	public void left(int beta) {
		alpha += beta;
		if(alpha >= 360) {
			alpha -= 360;
		}else if(alpha < 0){
			alpha += 360;
		}
	}

	/**
	 * Går till punkten newX, newY utan att rita. Pennans läge (sänkt eller lyft)
	 * och huvudets riktning påverkas inte.
	 */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		alpha = 90;
	}

	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}

	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
	public int getDirection() {
		return alpha;
	}
}
