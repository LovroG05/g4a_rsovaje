import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RezultatiService {
	private static final String DB_URL = "jdbc:mysql://193.2.190.23:3306/baza";
	private static final String USER = "username";
	private static final String PASS = "password";

	public void insertRezultat(String igra, String igralec, String rezultat) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO rezultati(igra, igralec, zacetek, konec, rezultat) VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, igra);
			pstmt.setString(2, igralec);
			pstmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setInt(5, Integer.valueOf(rezultat));

			pstmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Ponovitve> najManjAktivnih10(String imeIgre) {
		ArrayList<Ponovitve> toReturn = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			PreparedStatement st = conn.prepareStatement("""
										SELECT igralec, COUNT(*) AS ponovitve
										FROM rezultati
										WHERE igra=?
										GROUP BY igralec
										ORDER BY ponovitve ASC
										LIMIT 10;
					""");
			st.setString(1, imeIgre);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				toReturn.add(
						new Ponovitve(
								rs.getString("igralec"),
								rs.getInt("ponovitve")
						)
				);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public HashMap<String, Rezultat> topIgralci() {
		HashMap<String, Rezultat> toReturn = new HashMap<>();

		for(String igra : vseIgre()) {
			toReturn.put(igra, topN(igra, 1).get(0));
		}

		return toReturn;
	}

	public List<Rezultat> top10(String imeIgre) {
		return topN(imeIgre, 10);
	}

	public List<Rezultat> topN(String imeIgre, int n) {
		ArrayList<Rezultat> toReturn = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			PreparedStatement st = conn.prepareStatement("SELECT * FROM rezultati WHERE igra=? ORDER BY rezultat DESC LIMIT ?;");
			st.setString(1, imeIgre);
			st.setInt(2, n);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				toReturn.add(
						new Rezultat(
								rs.getInt("id"),
								rs.getString("igra"),
								rs.getString("igralec"),
								rs.getTimestamp("zacetek"),
								rs.getTimestamp("konec"),
								rs.getInt("rezultat")
						)
				);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public Ponovitve igraIgrana(String imeIgre) {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) AS total FROM rezultati WHERE igra=?;");
			st.setString(1, imeIgre);
			ResultSet rs = st.executeQuery();

			while(rs.next()) {
				return new Ponovitve(imeIgre, rs.getInt("total"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Ponovitve> igraIgrana() {
		ArrayList<Ponovitve> toReturn = new ArrayList<>();

		for(String igra : vseIgre()) {
			toReturn.add(igraIgrana(igra));
		}

		return toReturn;
	}

	private List<String> vseIgre() {
		ArrayList<String> toReturn = new ArrayList<>();

		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT DISTINCT igra FROM rezultati;");

			while(rs.next()) {
				toReturn.add(rs.getString("igra"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return toReturn;
	}

	public record Rezultat(int id, String igra, String igralec, Timestamp zacetek, Timestamp konec, int rezultat) {
		public String toTr() {
			return "<tr>" +
					"<td>" + id + "</td>" +
					"<td>" + igra + "</td>" +
					"<td>" + igralec + "</td>" +
					"<td>" + zacetek + "</td>" +
					"<td>" + konec + "</td>" +
					"<td>" + rezultat + "</td>" +
					"</tr>";
		}
	}

	public record Ponovitve(String igralec, int ponovitve) {
		public String toTr() {
			return "<tr>" +
					"<td>" + igralec + "</td>" +
					"<td>" + ponovitve + "</td>" +
					"</tr>";
		}
	}
}
