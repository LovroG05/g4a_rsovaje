import java.io.Serializable;
import java.util.Arrays;

public class Zapis implements Serializable {
	private final char[] igralec;
	private int najbolsiDosezek;
	private int steviloPoskusov;

	public Zapis(char[] igralec, int najbolsiDosezek, int steviloPoskusov) {
		this.igralec = Arrays.copyOf(igralec, 15);
		this.najbolsiDosezek = najbolsiDosezek;
		this.steviloPoskusov = steviloPoskusov;
	}

	public char[] getIgralec() {
		return igralec;
	}

	public int getNajbolsiDosezek() {
		return najbolsiDosezek;
	}

	public void setNajbolsiDosezek(int najbolsiDosezek) {
		this.najbolsiDosezek = najbolsiDosezek;
	}

	public int getSteviloPoskusov() {
		return steviloPoskusov;
	}

	public void setSteviloPoskusov(int steviloPoskusov) {
		this.steviloPoskusov = steviloPoskusov;
	}

	@Override
	public String toString() {
		return "Zapis{" +
				"igralec=" + Arrays.toString(igralec) +
				", najbolsiDosezek=" + najbolsiDosezek +
				", steviloPoskusov=" + steviloPoskusov +
				'}';
	}
}
