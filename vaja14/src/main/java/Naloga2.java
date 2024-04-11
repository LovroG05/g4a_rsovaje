import java.sql.*;
import java.util.concurrent.ThreadLocalRandom;

public class Naloga2 {
	private static final String DB_URL = "jdbc:mysql://193.2.190.23:3306/baza";
	private static final String USER = "username";
	private static final String PASS = "password";

	private static final String INSERT_PLAYER =
			"INSERT INTO rezultati(igra, igralec, zacetek, konec, rezultat) VALUES(?, ?, ?, ?, ?)";

	public static void main(String[] args) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			// Insert players
			for(String player : Greh.USERNAMES) {
				for(String game : Greh.GAME_NAMES) {
					int repeats = (int) (Math.random() * 150);

					for(int i = 0; i < repeats; i++) {
						PreparedStatement pstmt = conn.prepareStatement(INSERT_PLAYER);
						TimestampCombo timestampCombo = getRandomTimestamp();

						pstmt.setString(1, game);
						pstmt.setString(2, player);
						pstmt.setTimestamp(3, timestampCombo.start);
						pstmt.setTimestamp(4, timestampCombo.end);
						pstmt.setInt(5, (int) (Math.random() * 100));

						pstmt.execute();
					}
				}
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static TimestampCombo getRandomTimestamp() {
		long startMillis = Timestamp.valueOf("2020-01-01 00:00:00").getTime();
		long endMillis = Timestamp.valueOf("2020-12-31 23:59:59").getTime();

		long randomMillis = ThreadLocalRandom.current().nextLong(startMillis, endMillis + 1);

		return new TimestampCombo(
				new Timestamp(randomMillis),
				new Timestamp(
						randomMillis +
								(int) (Math.random() * (60000 - 10000) + 10000)
				)
		);
	}

	private record TimestampCombo(Timestamp start, Timestamp end) {
	}
}
