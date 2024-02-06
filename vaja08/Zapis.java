import java.util.Arrays;

public class Zapis {
	private char a;
	private char b;
	private byte[] c;

	public Zapis(char a, char b, byte[] c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public char getA() {
		return a;
	}

	public void setA(char a) {
		this.a = a;
	}

	public char getB() {
		return b;
	}

	public void setB(char b) {
		this.b = b;
	}

	public byte[] getC() {
		return c;
	}

	public void setC(byte[] c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Zapis{" +
				"a=" + a +
				", b=" + b +
				", c=" + Arrays.toString(c) +
				'}';
	}
}
