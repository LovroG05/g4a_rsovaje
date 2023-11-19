public class Naloga9 {
	public static void main(String[] args) {
		System.out.println(fakulteta(5));
	}

	private static int fakulteta(int a) {
		if(a > 1) {
			return a * fakulteta(--a);
		}

		return a;
	}
}
