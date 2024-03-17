import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Random;

public class Naloga3 {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";

	private static final String INSERT_INTO = "INSERT INTO obisk(opomba) values(?);";
	private static final String SELECT = "SELECT COUNT(*) AS vsota FROM obisk;";

	public static void main(String[] args) {
		Spaga spaga = new Spaga();
		spaga.start();

		try {
			Thread.sleep(200 * 1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		spaga.interrupt();

		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT)
		) {
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				System.out.println("Vstoa: " + resultSet.getString("vsota"));
				System.exit(0);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static String nakljucnostJeLepaCednost() {
		byte[] array = new byte[15];
		for(int i = 0; i < array.length; i++) {
			array[i] = (byte) (new Random().nextInt(25) + 97);
		}

		return new String(array, StandardCharsets.UTF_8);
	}

	private static class Spaga extends Thread {
		@Override
		public void run() {
			while(true) {
				try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
					PreparedStatement preparedStatement = conn.prepareStatement(INSERT_INTO)
				) {
					preparedStatement.setString(1, nakljucnostJeLepaCednost());
					preparedStatement.execute();
				} catch(Exception e) {
					e.printStackTrace();
				}

				try {
					Thread.sleep(20 * 1000);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
