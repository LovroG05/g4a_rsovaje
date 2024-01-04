import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @apiNote Ura je <s>0100</s> 0200
 */
public class Sistem {
	private final LinkedList<User> uporabniki = new LinkedList<>();

	public Sistem() {
		try {
			// Poindeksiramo obstoječe uporabnike
			Scanner sc = new Scanner(new FileInputStream("topten.txt"));

			while(sc.hasNext()) {
				uporabniki.add(parseLine(sc.nextLine()));
			}

			sc.close();
		} catch(IOException e) {
			e.printStackTrace();
		}

		// 2B - sorry res ne zastopm navodila, naredu sm posvoje :/
		ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
		Runnable task = () -> {
			String[] ime = getRandomLine("imena.txt").split(" ");
			beleziRezultat(ime[0], ime[1], getRandomLine("nicki.txt"), (int) (Math.random() * 1000));
		};

		scheduler.scheduleAtFixedRate(task, 0, 30, TimeUnit.SECONDS);
	}

	/**
	 * @apiNote Zelo, zelo, zelo grdo; ew, fuj, bleh, ampak so navodila taka :/
	 */
	public void beleziRezultat(String ime, String priimek, String nick, int score) {
		String polnoIme = ime + " " + priimek;

		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedDate = currentDate.format(formatter);

		User u1 = new User(1, polnoIme, nick, score, 0, formattedDate);
		for(User u : uporabniki) {
			if(u.getName().equals(polnoIme)) {
				u1 = u;
			} else if(u.getNick().equals(nick)) {
				u1 = u;
			}
		}

		// Update user
		if(score > u1.getScore()) {
			u1.setScore(score);
		}
		u1.setIger(u1.getIger() + 1);

		// Dodaj userja
		uporabniki.push(u1);

		// Posortiraj
		uporabniki.sort(Comparator.comparingInt(User::getScore));

		// Posodobi številke
		for(int i = 1; i <= 10; i++) {
			uporabniki.get(i - 1).setNumber(i);
		}

		// Pobriš preslabe >:(
		while(uporabniki.size() > 10) {
			uporabniki.removeLast();
		}

		saveResult();
	}

	public LinkedList<User> getTable() {
		return uporabniki;
	}

	private void saveResult() {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("topten.txt", false))) {
			for(User u : uporabniki) {
				writer.write(u.toString());
				writer.newLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private User parseLine(String input) {
		// Hmm, tole je pa kar zanimivo
		Pattern pattern = Pattern.compile("(\\d+)\\. user:(.+?) nick:(.+?) score:(\\d+) iger:(\\d+) datum:(.+)");
		Matcher matcher = pattern.matcher(input);

		if(matcher.find()) {
			String user = matcher.group(2);
			String nick = matcher.group(3);

			// Pogoji za velikost (upajmo da delajo hmmm)...
			if(user.split(" ").length == 0 || user.split(" ").length > 33) {
				throw new IllegalArgumentException("Invalid input");
			}

			if(nick.split(" ").length > 32) {
				throw new IllegalArgumentException("Invalid input");
			}

			return new User(
					Integer.parseInt(matcher.group(1)),
					user,
					nick,
					Integer.parseInt(matcher.group(4)),
					Integer.parseInt(matcher.group(5)),
					matcher.group(6).trim()
			);
		} else {
			throw new IllegalArgumentException("Invalid input string");
		}
	}

	private static String getRandomLine(String filePath) {
		try {
			List<String> lines = new ArrayList<>();

			try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line;
				while((line = reader.readLine()) != null) {
					lines.add(line);
				}
			}

			Random random = new Random();
			int randomIndex = random.nextInt(lines.size());

			return lines.get(randomIndex);
		} catch(IOException e) {
			return "";
		}
	}
}
