public class Naloga8 {
	public static void main(String[] args) {
		System.out.println(delitelj(12, 6));
	}

	private static int delitelj(int a, int b) {
		if(b > 0) {
			return delitelj(b, a % b);
		}

		return a;
	}
}
