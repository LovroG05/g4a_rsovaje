import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Naloga3 {
	private static final List<Zapis> igre = IgreService.listIgre();

	public static void main(String[] args) {
		System.out.println(igre);
		pokaziNajboljsih10();
	}

	private static void novPoskus(char[] igralec) {
		Optional<Zapis> oz = findZapis(igralec);

		if(oz.isPresent()) {
			Zapis z = oz.get();
			z.setSteviloPoskusov(z.getSteviloPoskusov() + 1);
		} else {
			igre.add(new Zapis(igralec, 0, 1));
		}

		IgreService.saveIgre(igre);
	}

	private static void beleziRezultat(char[] igralec, int rezultat) {
		Optional<Zapis> oz = findZapis(igralec);

		if(oz.isPresent()) {
			Zapis z = oz.get();
			if(rezultat > z.getNajbolsiDosezek()) {
				z.setNajbolsiDosezek(rezultat);
			}

			IgreService.saveIgre(igre);
		}
	}

	private static Optional<Zapis> findZapis(char[] igralec) {
		char[] modIgr = Arrays.copyOf(igralec, 15);

		return igre.stream().
				filter(zapis -> Arrays.equals(zapis.getIgralec(), modIgr))
				.findFirst();
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
