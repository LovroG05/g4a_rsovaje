import java.util.Comparator;
import java.util.List;

public class Naloga2 {
	private static final List<Zapis> igre = IgreServiceOld.listIgre();

	public static void main(String[] args) {
		pokaziNajboljsih10();
	}

	public static void pokaziNajboljsih10() {
		System.out.println("\t\t\trezultat\tposkusov");
		System.out.println("--------------------------------------");

		List<Zapis> topTen = igre.stream()
				.sorted(
						Comparator.comparingInt(Zapis::getNajbolsiDosezek)
				)
				.limit(10)
				.toList()
				.reversed();

		for(int i = 0; i < topTen.size(); i++) {
			Zapis z = topTen.get(i);
			String igralec = new String(z.getIgralec()).trim();

			System.out.printf(
					"%d\t%s\t%d\t\t\t%d\n",
					i + 1,
					igralec.length() > 3 ? igralec : igralec + "\t",
					z.getNajbolsiDosezek(),
					z.getSteviloPoskusov()
			);
		}
	}
}
