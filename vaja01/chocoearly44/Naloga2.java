public class Naloga2 {
	public static void main(String[] args) {
		//int[] a = new int[]{1, 2, 3, 2, 1};
		int[] a = new int[41];

		System.out.println(palind(a, 0, a.length - 1));
	}

	private static boolean palind(int[] a, int i, int j) {
		if(i >= j) {
			return true;
		}

		if(a[i] != a[j]) {
			return false;
		}

		return palind(a, ++i, --j);
	}
}
