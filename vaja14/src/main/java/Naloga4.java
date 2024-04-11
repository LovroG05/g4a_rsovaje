import org.json.JSONArray;
import org.json.JSONObject;

import static spark.Spark.*;

public class Naloga4 {
	private static final RezultatiService rs = new RezultatiService();

	public static void main(String[] args) {
		secure("keystore.jks", "password", null, null); //spremeni to (iz vaje 13, ki pa je žal ni objavljene (poglej navodila vaje 13))
		port(4567); //port

		get("/api/v2/top10/:ime", (req, res) -> {
			String imeIgre = req.params("ime");
			JSONArray toReturn = new JSONArray();

			rs.top10(imeIgre).forEach(rezultat -> {
				JSONObject rez = new JSONObject();
				rez.put("igra", imeIgre);
				rez.put("igralec", rezultat.igralec());
				rez.put("rezultat", rezultat.rezultat());

				toReturn.put(rez);
			});

			return toReturn.toString();
		});

		get("/api/v2/topIgralci", (req, res) -> {
			String imeIgre = req.params("ime");
			JSONObject toReturn = new JSONObject();

			rs.topIgralci().forEach((s, rezultat) -> {
				JSONObject rez = new JSONObject();
				rez.put("igra", s);
				rez.put("igralec", rezultat.igralec());
				rez.put("rezultat", String.valueOf(rezultat.rezultat())); //tako je specificirano v navodilih :/
				toReturn.append(s, rez);
			});

			return toReturn.toString();
		});

		get("/api/v2/igraIgrana/:ime", (req, res) -> {
			String imeIgre = req.params("ime");
			JSONObject toReturn = new JSONObject();

			toReturn.put("igra", imeIgre);
			toReturn.put("igrana", rs.igraIgrana(imeIgre).ponovitve());

			return toReturn.toString();
		});

		get("/api/v2/porocilo", (req, res) -> Naloga3.natisniNalogo("Top igralci za vsako", Naloga3.generateTable(rs.topIgralci())));

		post("/api/v2", (request, response) -> {
			JSONObject obj = new JSONObject(request.body());

			rs.insertRezultat(
					obj.getString("igra"),
					obj.getString("igralec"),
					obj.getString("rezultat")
			);

			return "{\"status\",\"ok\"}";
		});

		get("*", (req, res) -> "{\"404\":\"informacija ni dostopna\"}");
	}
}
