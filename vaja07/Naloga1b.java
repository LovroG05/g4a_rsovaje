import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Naloga1b {
	private static HashMap<String, Integer> besede = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// Poindeksiramo besede
		Scanner sc = new Scanner(new FileInputStream("dromidska-podoba.txt"));

		while(sc.hasNext()) {
			String beseda = sc.next();
			besede.put(beseda, besede.getOrDefault(beseda, 0) + 1);
		}

		sc.close();
		a1();
		a2();
	}

	private static void a1() {
		Map<String, Integer> sortedMap = besede.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(
						Collectors.toMap(
								Map.Entry::getKey,
								Map.Entry::getValue,
								(e1, e2) -> e1,
								LinkedHashMap::new
						)
				);

		System.out.println(sortedMap);
	}

	private static void a2() {
		Map<String, Integer> sortedMap = besede.entrySet()
				.stream()
				.sorted(
						Comparator.comparing(
								(Map.Entry<String, Integer> entry) -> entry.getKey().charAt(0)
						).thenComparing(
								Comparator.comparingInt(
												(Map.Entry<String, Integer> value) -> value.getKey().length()
										)
										.thenComparingInt(Map.Entry::getValue)
						)
				)
				.collect(
						Collectors.toMap(
								Map.Entry::getKey,
								Map.Entry::getValue,
								(e1, e2) -> e1,
								LinkedHashMap::new
						)
				);

		System.out.println(sortedMap);
	}
}
