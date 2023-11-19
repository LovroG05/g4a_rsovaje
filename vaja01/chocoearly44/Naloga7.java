public class Naloga7 {
	public static void main(String[] args) {
		System.out.println(obrni("abcd", 0));
		System.out.println(obrni(123));
	}

	private static String obrni(String niz, int i) {
		if(i < niz.length() / 2) {
			char a = niz.charAt(i);
			char b = niz.charAt(niz.length() - 1 - i);

			StringBuilder sb = new StringBuilder(niz);
			sb.setCharAt(i, b);
			sb.setCharAt(niz.length() - 1 - i, a);

			niz = sb.toString();
			niz = obrni(niz, ++i);
		}

		return niz;
	}

	private static int obrni(int a) {
		if(a < 10) {
			return a;
		}

		int stevka = a % 10;
		int ostanek = (a - stevka) / 10;

		return (int) ((stevka * Math.pow(10, (int) Math.log10(ostanek) + 1)) + obrni(ostanek));
	}
}
