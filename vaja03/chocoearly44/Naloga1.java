import java.util.LinkedList;

public class Naloga1 {
	public static void main(String[] args) {
		LinkedList l1 = new LinkedList<Integer>();
		var l2 = new LinkedList<Integer>();

		System.out.println(l1.getClass().getName());
		System.out.println(l2.getClass().getName());

		l1.add(3);
		System.out.println(l1);
		l1.add(new Integer(6));
		System.out.println(l1);
		System.out.println(l1.remove());
		System.out.println(l1);

		// Dodajanje/jemanje iz začeteka
		l1.addFirst(1);
		l1.removeFirst();

		// Dodajanje/jemanje iz konca
		l1.addLast(1);
		l1.removeLast();
	}
}

/*
	a) ArrayList implementira Serializable
	b) java.util.LinkedList; da
 */