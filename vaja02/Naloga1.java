public class Naloga1 {
	public static void main(String[] args) {
		System.out.println(zmnozi("21", "53"));
	}

	private static String zmnozi(String a, String b) {
		if(b.isEmpty() || a.isEmpty()) {
			return "";
		}

		if(a.length() == 1 && b.length() == 1) {
			return String.valueOf((a.charAt(0) - '0') * (b.charAt(0) - '0'));
		}

		StringBuilder a1 = new StringBuilder(a);
		a1.reverse();

		StringBuilder summa = new StringBuilder();
		summa.append(
				zmnozi(
						a1.substring(1),
						String.valueOf(b.charAt(0) - '0')
				)
		);
		summa.append((a1.charAt(0) - '0') * (b.charAt(0) - '0'));

		return sestej(
				"" + Integer.parseInt(summa.toString()) * ((int) (Math.pow(10, b.length() - 1))),
				zmnozi(a, b.substring(1))
		);
	}

	public static String sestej(String a, String b) {
		int maxLength = Math.max(a.length(), b.length());
		a = padString(a, maxLength);
		b = padString(b, maxLength);

		StringBuilder toReturn = new StringBuilder();
		int carry = 0;

		for (int i = a.length() - 1; i >= 0; i--) {
			int aa = a.charAt(i) - '0';
			int bb = b.charAt(i) - '0';

			int sum = aa + bb + carry;

			carry = sum / 10;
			toReturn.append(sum % 10);
		}

		if (carry > 0) {
			toReturn.append(carry);
		}

		return toReturn.reverse().toString();
	}

	private static String padString(String str, int length) {
		StringBuilder paddedStr = new StringBuilder(str);
		while(paddedStr.length() < length) {
			paddedStr.insert(0, '0');
		}
		return paddedStr.toString();
	}
}