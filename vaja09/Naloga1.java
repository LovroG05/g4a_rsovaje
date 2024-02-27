import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Naloga1 {
	private static final List<Zapis> igre = IgreServiceOld.listIgre();

	public static void main(String[] args) {
		System.out.println(igre);
	}

	private static void novPoskus(char[] igralec) {
		Optional<Zapis> oz = findZapis(igralec);

		if(oz.isPresent()) {
			Zapis z = oz.get();
			z.setSteviloPoskusov(z.getSteviloPoskusov() + 1);
		} else {
			igre.add(new Zapis(igralec, 0, 1));
		}

		IgreServiceOld.saveIgre(igre);
	}

	private static void beleziRezultat(char[] igralec, int rezultat) {
		Optional<Zapis> oz = findZapis(igralec);

		if(oz.isPresent()) {
			Zapis z = oz.get();
			if(rezultat > z.getNajbolsiDosezek()) {
				z.setNajbolsiDosezek(rezultat);
			}

			IgreServiceOld.saveIgre(igre);
		}
	}

	private static Optional<Zapis> findZapis(char[] igralec) {
		char[] modIgr = Arrays.copyOf(igralec, 15);

		return igre.stream().
				filter(zapis -> Arrays.equals(zapis.getIgralec(), modIgr))
				.findFirst();
	}
}
