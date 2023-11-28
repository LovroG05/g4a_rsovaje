import java.awt.*;
import java.util.LinkedList;

public class Naloga2 {
	public static void main(String[] args) {
		LinkedList<RTocka> ll = new LinkedList<>();

		for(int i = 0; i < 7; i++) {
			ll.add(new RTocka(i + 5, 4, Color.YELLOW));
		}

		//circle
		System.out.println(ll);

		for(int i = 0; i < ll.size(); i++) {
			RTocka zadni = ll.getLast();

			ll.removeLast();
			ll.addFirst(zadni);
		}

		System.out.println(ll);
	}

	public record RTocka(int x, int y, java.awt.Color barva) {
	}
}
