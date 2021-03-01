package SportsAcademy;

public class Player {
	private int id;
	private String name;
	private byte age;
	private String label;
	private short matchesPlayed;
	
	public Player() {
		super();
	}
	public Player(int id, String name, byte age, String label, short matchesPlayed) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.label = label;
		this.matchesPlayed = matchesPlayed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public short getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(short matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	
}
