import java.awt.*;
import java.util.LinkedList;

public class Naloga2 {
	public static void main(String[] args) {
		a();
		b();
	}

	private static void a() {
		LinkedList<RTocka> ll = new LinkedList<>();

		for(int i = 5; i < 12; i++) {
			ll.add(new RTocka(i, 10, Color.YELLOW));
		}

		System.out.println(ll);

		for(int i = 0; i < 6; i++) {
			ll.push(ll.removeLast());
		}

		System.out.println(ll);
	}

	private static void b() {
		LinkedList<RTocka> ll = new LinkedList<>();

		for(int i = 5; i < 12; i++) {
			ll.add(new RTocka(i, 10, Color.YELLOW));
		}

		System.out.println(ll);

		for(int i = 0; i < 6; i++) {
			ll.removeFirst();

			RTocka ls = ll.getLast();
			ll.addLast(new RTocka(ls.x() + 1, ls.y(), Color.RED));
		}

		System.out.println(ll);
	}

	public record RTocka(int x, int y, java.awt.Color barva) {
	}
}
