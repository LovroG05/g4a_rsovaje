
/**
 * class Smer
 * <p>
 * vsebuje trenutno smer gibanja in
 * metodi, ki omogočata spremembo smeri
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Smer {
	private int x;
	private int y;

	public Smer() {
		// privzeto desno horizontalno
		y = 0;
		x = 1;
	}

	public Smer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* desno */
	public void ccw() {
		int t = x;
		x = y;
		y = -t;
	}

	/* levo */
	public void cw() {
		int t = y;
		y = x;
		x = -t;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
