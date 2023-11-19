public class Naloga1 {
	public static void main(String[] args) {
		test(5, 1);
	}

	private static void test(int najv, int najm) {
		if(najv >= najm) {
			System.out.println(najv);

			test(--najv, najm);
		}
	}
}