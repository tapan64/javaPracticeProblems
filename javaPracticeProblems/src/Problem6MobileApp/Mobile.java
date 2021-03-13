package Problem6MobileApp;

public class Mobile {
	private int id;
	private String model;
	private double price;
	private String dateOfManufature;

	public Mobile() {
		super();
	}

	public Mobile(int id, String model, double price, String dateOfManufature) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
		this.dateOfManufature = dateOfManufature;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDateOfManufature() {
		return dateOfManufature;
	}

	public void setDateOfManufature(String dateOfManufature) {
		this.dateOfManufature = dateOfManufature;
	}

}
