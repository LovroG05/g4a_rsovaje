import java.util.Arrays;

public class Naloga4 {
	public static void main(String[] args) {
		int[][] a = new int[5][5];

		napolni(a, 0, 0);
		System.out.println(Arrays.deepToString(a));
	}

	private static void napolni(int[][] a, int i, int j) {
		a[i][j] = 1;

		if(i < a.length - 1) {
			int k = i + 1;
			napolni(a, k, j);
		}

		if(j < a[i].length - 1) {
			napolni(a, i, ++j);
		}
	}
}
