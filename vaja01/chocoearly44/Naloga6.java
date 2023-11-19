public class Naloga6 {
	public static void main(String[] args) {
		String niz = "To je primer izbranega podniza v nizu podniz podniz";
		String iskaniPodniz = "podniz";

		System.out.println(podniz(niz, iskaniPodniz));
	}

	private static int podniz(String niz, String pod) {
		if(niz.length() < pod.length()) {
			return 0;
		}

		int i = niz.startsWith(pod) ? 1 : 0;
		return i + podniz(niz.substring(1), pod);
	}
}
