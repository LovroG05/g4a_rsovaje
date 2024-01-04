import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Naloga1a {
	public static void main(String[] args) {
		HashMap<Character, Integer> znaki = new HashMap<>();

		try(BufferedReader reader = new BufferedReader(new FileReader("dromidska-podoba.txt"))) {
			int character;

			while((character = reader.read()) != -1) {
				char cr = (char) character;

				int rep = znaki.getOrDefault(cr, 0);
				znaki.put(cr, ++rep);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println(znaki);
	}
}
