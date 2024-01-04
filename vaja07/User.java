public class User {
	private int number;
	private String name;
	private String nick;
	private int score;
	private int iger;
	private String datum;

	public User(int number, String name, String nick, int score, int iger, String datum) {
		this.number = number;
		this.name = name;
		this.nick = nick;
		this.score = score;
		this.iger = iger;
		this.datum = datum;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getIger() {
		return iger;
	}

	public void setIger(int iger) {
		this.iger = iger;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return String.format(
				"%d. user:%s nick:%s score:%d iger:%d datum:%s",
				number, name, nick, score, iger, datum
		);
	}
}
