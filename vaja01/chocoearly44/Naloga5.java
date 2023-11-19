public class Naloga5 {
	public static void main(String[] args) {
		System.out.println(genPalindr("abc", false));
	}

	private static String genPalindr(String niz, boolean sod) {
		return genPalindr(niz, sod, niz.length() - 1);
	}

	private static String genPalindr(String niz, boolean sod, int i) {
		if(sod ? i >= 0 : i > 0) {
			niz += niz.charAt(sod ? i : i - 1);
			niz = genPalindr(niz, sod, --i);
		}

		return niz;
	}
}
