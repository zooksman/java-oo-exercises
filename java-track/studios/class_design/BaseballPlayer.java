package class_design;

public class BaseballPlayer {
	public String name;
	public int number;
	public String bat;
	public int hits = 0;
	public int rbis = 0;
	public int games = 0;
	
	public BaseballPlayer(String name, int number, String bat) {
		this.name = name;
		this.number = number;
		this.bat = bat;
	}
	
	public void game(int hits, int rbis) {
		this.hits += hits;
		this.rbis += rbis;
		this.games++;
	}
}
