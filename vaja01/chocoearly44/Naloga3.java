public class Naloga3 {
	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 5, 4, 44, 22, 0, 66, 33, 21};
		System.out.println(najm(a, 0, 0));
	}

	private static int najm(int[] a, int index, int minIndex) {
		if(index < a.length - 1) {
			minIndex = najm(a, ++index, minIndex);
		}

		return a[index] < a[minIndex] ? index : minIndex;
	}
}
