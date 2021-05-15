package Problem4InsuranceApp;

public class Policy {
	private int id;
	private int number;
	private String type;
	private double premiumFee;
	private String premiumMode;

	public Policy() {
		super();
	}

	public Policy(int id, int number, String type, double premiumFee, String premiumMode) {
		super();
		this.id = id;
		this.number = number;
		this.type = type;
		this.premiumFee = premiumFee;
		this.premiumMode = premiumMode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPremiumFee() {
		return premiumFee;
	}

	public void setPremiumFee(double premiumFee) {
		this.premiumFee = premiumFee;
	}

	public String getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(String premiumMode) {
		this.premiumMode = premiumMode;
	}

}
