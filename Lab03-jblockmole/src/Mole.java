
public class Mole {
	private Graphics g = new Graphics(30, 50, 10);

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, 0, g.getWidth(), 14, Colors.SKY);
		g.rectangle(0, 14, g.getWidth(), 15, Colors.GRASS);
		g.rectangle(0, 15, g.getWidth(), g.getHeight(), Colors.SOIL);

	}

	public void dig() {
		int x = g.getWidth() / 2; // För att börja på mitten
		int y = g.getHeight() / 2;
		while (true) {
			if (x >= 0) {
				if (x < g.getWidth()) {
					if (y >= 14) {
						if (y < g.getHeight()) {
							g.block(x, y, Colors.MOLE);
							char key = g.waitForKey();
							if (y == 14) {
								g.block(x,y,Colors.GRASS);
							} else {
								g.block(x, y, Colors.TUNNEL);
							}
							if (key == 'w') {
								y = y - 1;
							} else if (key == 'a') {
								x = x - 1;
							} else if (key == 's') {
								y = y + 1;
							} else if (key == 'd') {
								x = x + 1;
							}
						} else {
							y--;
						}
					} else {
						y++;
					}
				} else {
					x--;
				}
			} else {
				x++;
			}
		}
	}
}
