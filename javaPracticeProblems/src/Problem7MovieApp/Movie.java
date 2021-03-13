package Problem7MovieApp;

public class Movie {
	private int id;
	private String name;
	private String[] casting;
	private short yearOfRelease;
	private byte rating;

	public Movie() {
		super();
	}

	public Movie(int id, String name, String[] casting, short yearOfRelease, byte rating) {
		super();
		this.id = id;
		this.name = name;
		this.casting = casting;
		this.yearOfRelease = yearOfRelease;
		this.rating = rating;
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

	public String[] getCasting() {
		return casting;
	}

	public void setCasting(String[] casting) {
		this.casting = casting;
	}

	public short getYearOfRelease() {
		return yearOfRelease;
	}

	public void setYearOfRelease(short yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

}
