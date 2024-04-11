import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Naloga3 {
	private static final RezultatiService rs = new RezultatiService();

	private static final String IME_IGRE = "IGRA";
	private static final String AVTOR = "AVTOR";

	public static void main(String[] args) {
		natisniNalogo("Kolikokrat igrana", "a", generateTablePonovitve(rs.igraIgrana()));
		natisniNalogo("Top igralci za vsako", "b", generateTable(rs.topIgralci()));
		natisniNalogo("Top 10", "c", generateTableRezultati(rs.top10(IME_IGRE)));
		natisniNalogo("Najmanj aktivnih 10", "d", generateTablePonovitve(rs.najManjAktivnih10(IME_IGRE)));
	}

	private static void natisniNalogo(String imePorocila, String naloga, String content) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyyddMM");

		try(PrintWriter pw = new PrintWriter(String.format("porocila/%s_porocilo_naloga3_%s.html", now.format(date), naloga))) {
			pw.write(generateHeader(imePorocila));
			pw.write("<br>");
			pw.write(content);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static String natisniNalogo(String imePorocila, String content) {
		return generateHeader(imePorocila) + "<br>" + content;
	}

	private static String generateHeader(String imePorocila) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");

		return String.format("<h2>%s igre '%s'</h2>" +
						"<h4>Generirano: %s ob %s</h4>" +
						"<h4>Pripravil(a): %s</h4>",
				imePorocila, IME_IGRE, now.format(date), now.format(time), AVTOR
		);
	}

	private static String generateTablePonovitve(List<RezultatiService.Ponovitve> ponovitves) {
		StringBuilder toReturn = new StringBuilder(generateTableTag());

		for(RezultatiService.Ponovitve ponovitve : ponovitves) {
			toReturn.append(ponovitve.toTr());
		}

		toReturn.append("</table>");
		return toReturn.toString();
	}

	public static String generateTable(HashMap<String, RezultatiService.Rezultat> ponovitves) {
		StringBuilder toReturn = new StringBuilder(generateTableTag());

		for(Map.Entry<String, RezultatiService.Rezultat> result : ponovitves.entrySet()) {
			RezultatiService.Rezultat rez = result.getValue();

			toReturn.append("<tr>");
			toReturn.append("<td>" + result.getKey() + "</td>");
			toReturn.append("<td>" + rez.igralec() + "</td>");
			toReturn.append("<td>" + rez.rezultat() + "</td>");
			toReturn.append("<td>" + rez.konec() + "</td>");
			toReturn.append("</tr>");
		}

		toReturn.append("</table>");
		return toReturn.toString();
	}

	private static String generateTableRezultati(List<RezultatiService.Rezultat> ponovitves) {
		StringBuilder toReturn = new StringBuilder(generateTableTag());

		for(RezultatiService.Rezultat rez : ponovitves) {
			toReturn.append(rez.toTr());
		}

		toReturn.append("</table>");
		return toReturn.toString();
	}

	private static String generateTableTag() {
		return "<style>\n" +
				"table, th, td {\n" +
				"  border: 1px solid black;\n" +
				"}\n" +
				"</style>" +
				"<table>";
	}
}
